package com.name.battler;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.name.battler.player.Player;
import com.name.battler.player.action.Action;
import com.name.battler.player.action.Condition;
import com.name.battler.player.job.Job;
import com.name.battler.setting.JobManager;
import com.name.battler.setting.PlayerJudge;
import com.name.battler.setting.PlayerMaking;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.ConstantText;

/**
 * ゲーム進行に関するクラス
 */
public class GameProgress {

    // 定数
    /** 作成するプレイヤー数 */
    final int NAME_COUNT = 2;
    /** プレイヤーインデックス */
    final int FIRST_INDEX = 0;
    final int SECOND_INDEX = 1;
    /** 技の数の最大値 */
    final int ACTION_COUNT_MAX = 4;
    /** ランダムの定数 */
    final int RANDOM_HUNDRED = 100;
    final int PALIZE_RANDOM = 20;

    // 変数
    /** 入力用 */
    private Scanner scan;
    /** ランダム用 */
    private Random ran;
    /** 作成したプレイヤークラスを格納するリスト */
    private List<Player> playerList = new ArrayList<>();
    /** 判定用 */
    private PlayerJudge pj = new PlayerJudge();

    /**
     * メイン進行
     * 1. プレイヤーの作成
     * 2. 戦闘開始
     * 3. 終了
     */
    public void progress(){
        // 1. の最初のダイアログ
        Dialogue.showStartSettingText();


        /* --- 1. プレイヤーの作成 --- */
        // プレイヤーネームのためのリストを用意
        String[] playerName = new String[NAME_COUNT];

        // プレイヤーの名前を2つ作成
        for(int i=0; i<NAME_COUNT; i++){
            System.out.printf(ConstantText.NAME_PUT_TEXT.getText(), i+1);
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
            if(order.get(FIRST_INDEX).getCondition().equals(Condition.PALIZE.getName())){
                System.out.printf(ConstantText.PALIZE_TEXT.getText(), order.get(FIRST_INDEX).getName(), Condition.PALIZE.getName());
                isPalize = ran.nextInt(RANDOM_HUNDRED) - PALIZE_RANDOM <= 0;
            }

            if(!isPalize){
                // 優先行動選択
                int actionId = ran.nextInt(ACTION_COUNT_MAX);
                // 魔法使いはMPがあるとき呪文優先
                if(order.get(FIRST_INDEX).getJobId() == Job.WIZARD.getId()){
                    if(order.get(FIRST_INDEX).getMp() >= Action.THUNDER.getCost()){
                        // random 1-2
                        actionId = ran.nextInt(2)+1;
                    }
                }

                // 僧侶はダメージがあると回復優先
                if(order.get(FIRST_INDEX).getJobId() == Job.PRIEST.getId()){
                    if(order.get(FIRST_INDEX).getHp() <= -(Action.HEEL.getDamageRange().getRandomValue())){
                        // 僧侶の回復行動3
                        actionId = 3;
                    }
                }

                // 技行動
                int damage = order.get(FIRST_INDEX).selectAttack(actionId, order.get(SECOND_INDEX));
                order.get(SECOND_INDEX).decreaseHp(damage);
            }

            // 状態異常判定: 攻撃したほうが毒状態の時ダメージを受ける
            if(order.get(FIRST_INDEX).getCondition().equals(Condition.POISON.getName())){
                System.out.printf(ConstantText.POISON_DAMAGE_TEXT.getText(), order.get(FIRST_INDEX).getName(), Condition.POISON.getName());
                order.get(FIRST_INDEX).decreaseHp(Condition.POISON.getDamage());
            }

            // 死亡判定
            if(pj.isDead(order.get(SECOND_INDEX))){
                System.out.println();
                System.out.printf(ConstantText.DEAD_TEXT.getText(), order.get(SECOND_INDEX).getName());
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
        // 日本語入力文字化け対策 Shift-JIS
        scan = new Scanner(System.in, "Shift-JIS");

        // 変数
        String playerName = "";

        // 名前を入力（例外の場合やり直す）
        while(true){
            if(scan.hasNextLine()){
                // 名前を入力させ成功したら抜ける
                playerName = scan.nextLine();
                break;
            } else {
                // もう一度入力させる
                System.out.println(ConstantText.CREATE_PLAYER_NAME_ATTENTION_TEXT.getText());
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
        // 日本語入力文字化け対策 Shift-JIS
        scan = new Scanner(System.in, "Shift-JIS");

        // 全ジョブを出力
        JobManager jm = new JobManager();
        for(Player job : jm.getJobList()){
            System.out.printf("%s: %d  ", job.getJobName(), job.getJobId());
        }

        // 変数
        boolean isValidInput = false;
        int jobId = 0;

        // 名前を入力（例外の場合やり直す）
        while(!isValidInput){
            if(scan.hasNextInt()){
                // 名前を入力させ成功したら抜ける
                jobId = scan.nextInt();

                // ジョブが指定数以内で確定
                if(jobId < jm.getJobList().size()){
                    isValidInput = true;
                } else {
                    // エラーメッセージ
                    System.out.println(ConstantText.SELECT_JOB_ATTENTION_TEXT02.getText());
                }
            } else {
                // エラーメッセージをだしもう一度入力させる
                System.out.println(ConstantText.SELECT_JOB_ATTENTION_TEXT01.getText());
                scan.nextLine();
            }
        }

        return jobId;
    }
}
