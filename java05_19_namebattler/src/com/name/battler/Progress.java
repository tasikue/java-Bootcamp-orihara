package com.name.battler;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.setting.JobManager;
import com.name.battler.setting.PlayerJudge;
import com.name.battler.setting.PlayerMaking;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

/**
 * ゲーム進行に関するクラス
 */
public class Progress {

    // 定数
    /** 作成するプレイヤー数 */
    final int NAME_COUNT = 2;
    /** プレイヤーインデックス */
    final int FIRST_INDEX = 0;
    final int SECOND_INDEX = 1;
    /** 技の数の最大値（別のところから取得する？） */
    final int ACTION_COUNT_MAX = 4;
    /** ランダムの定数 */
    final int RANDOM_HUNDRED = 100;
    final int PALIZE_RANDOM = 20;

    // 変数
    private Scanner scan;
    private Random ran;
    private List<Player> playerList = new ArrayList<>();
    private PlayerJudge pj = new PlayerJudge();

    /**
     * メイン進行
     * 1. プレイヤーの作成
     * 2. 戦闘開始
     * 3. 終了
     */
    public void mainProgress(){
        // 1. の最初のダイアログ
        Dialogue.showStartSettingText();


        /* --- 1. プレイヤーの作成 --- */
        // プレイヤーネームのためのリストを用意
        String[] playerName = new String[NAME_COUNT];

        // プレイヤーの名前を2つ作成
        for(int i=0; i<NAME_COUNT; i++){
            System.out.printf(EnumText.NAME_PUT_TEXT.getText(), i+1);
            playerName[i] = createPlayerName();
            
            // プレイヤーを作成
            PlayerMaking playerMaking = new PlayerMaking(playerName[i], selectJobId());
            playerList.add(playerMaking.getPlayer());

            // プレイヤーのステータスを表示
            Dialogue.showStatusText(playerList.get(i));
        }
        // ここでscanを閉じる
        scan.close();

        // 1. の最後のダイアログ
        Dialogue.showStartSettingLastText();


        /* --- 2. バトルフェイズ --- */
        // 2. の最初のダイアログ
        Dialogue.showStartBattleText();

        // 2体のプレイヤーの先攻後攻の順でorderに収納する
        List<Player> order = playerList;
        if(order.get(FIRST_INDEX).getAgi() - order.get(SECOND_INDEX).getAgi() < 0){
            Collections.reverse(order);
        }


        // 戦闘ループ 
        while(true){
            // 技をランダムで仕込む
            ran = new Random();

            // 技行使とダメージ判定: 麻痺の場合20%の確率で動けない
            boolean isPalize = false;
            if(order.get(FIRST_INDEX).getCondition().equals(EnumCondition.PALIZE.getName())){
                System.out.printf(EnumText.PALIZE_TEXT.getText(), order.get(FIRST_INDEX).getName(), EnumCondition.PALIZE.getName());
                isPalize = ran.nextInt(RANDOM_HUNDRED) - PALIZE_RANDOM <= 0;
            }

            if(!isPalize){
                // 技行動
                int damage = order.get(FIRST_INDEX).selectAttack(ran.nextInt(ACTION_COUNT_MAX), order.get(SECOND_INDEX));
                order.get(SECOND_INDEX).decreaseHp(damage);
            }

            // 状態異常判定: 攻撃したほうが毒状態の時ダメージを受ける
            if(order.get(FIRST_INDEX).getCondition().equals(EnumCondition.POISON.getName())){
                System.out.printf(EnumText.POISON_DAMAGE_TEXT.getText(), order.get(FIRST_INDEX).getName(), EnumCondition.POISON.getName());
                order.get(FIRST_INDEX).decreaseHp(EnumCondition.POISON.getDamage());
            }

            // 死亡判定
            if(pj.isDead(order.get(SECOND_INDEX))){
                System.out.println();
                System.out.printf(EnumText.DEAD_TEXT.getText(), order.get(SECOND_INDEX).getName());
                break;
            }

            // 先攻後攻を入れ替える
            Collections.reverse(order);
        }

        // 2. の最後のダイアログ
        Dialogue.showStartSettingLastText();


        /* --- 3. 締め --- */
        // 勝者の決定
        // ステータス表示
        Dialogue.showStatusText(order.get(FIRST_INDEX));
        Dialogue.showStatusText(order.get(SECOND_INDEX));
    }


    /**
     * プレイヤーネームの入力を受け付けそれを出力する
     * @return プレイヤーネーム
     */
    private String createPlayerName(){
        // 日本語入力文字化け対策 Shift-JIS or UTF-8
        scan = new Scanner(System.in, "Shift-JIS");

        // 変数
        boolean isValidInput = false;
        String playerName = "";

        // 名前を入力（例外の場合やり直す）
        while(!isValidInput){
            try{
                // 名前を入力させ成功したら抜ける
                playerName = scan.nextLine();
                break;
            } catch (Exception e){

                // 例外の場合, エラーメッセージをだしもう一度入力させる
                System.out.println(e);
                System.out.println(EnumText.CREATE_PLAYER_NAME_ATTENTION_TEXT.getText());

                scan.nextLine();
            }
        }

        return playerName;
    }

    /**
     * ジョブIDの入力を受け付けそれを出力する
     * @return ジョブID
     */
    private int selectJobId(){
        // 日本語入力文字化け対策 Shift-JIS or UTF-8
        scan = new Scanner(System.in, "Shift-JIS");

        // 全ジョブを出力
        JobManager jm = new JobManager();
        int jobCount = 0;
        for(Player job : jm.getJobList()){
            System.out.printf("%s: %d  ", job.getJobName(), job.getJobId());
            jobCount++;
        }

        // 変数
        boolean isValidInput = false;
        int jobId = 0;

        // 名前を入力（例外の場合やり直す）
        while(!isValidInput){

            try{
                // 名前を入力させ成功したら抜ける
                jobId = scan.nextInt();

                // ジョブが指定数以上のときエラーを吐く
                if(jobId >= jobCount){
                    throw new Exception();
                }

                break;
            } catch (Exception e){

                // 例外の場合, エラーメッセージをだしもう一度入力させる
                System.out.println(e);
                System.out.println(EnumText.CREATE_PLAYER_NAME_ATTENTION_TEXT.getText());

                scan.nextLine();
            }
        }

        return jobId;
    }
}
