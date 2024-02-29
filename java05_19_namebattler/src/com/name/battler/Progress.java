package com.name.battler;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.name.battler.player.Player;
import com.name.battler.setting.PlayerMaking;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

public class Progress {

    // 定数
    final int NAME_COUNT = 2;
    final int FIRST_PLAYER = 0;
    final int SECOND_PLAYER = 1;
    final int ACTION_COUNT_MAX = 4;

    Scanner scan;
    List<Player> playerList = new ArrayList<>();

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
            PlayerMaking playerMaking = new PlayerMaking(playerName[i]);
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


        // 2体のプレイヤーの先攻後攻の順でorderPlayerに収納する
        List<Player> orderPlayer = new ArrayList<>();
        
        if(playerList.get(FIRST_PLAYER).getAgi() - playerList.get(SECOND_PLAYER).getAgi() >= 0){
            orderPlayer.add(playerList.get(FIRST_PLAYER));
            orderPlayer.add(playerList.get(SECOND_PLAYER));
        } else {
            orderPlayer.add(playerList.get(SECOND_PLAYER));
            orderPlayer.add(playerList.get(FIRST_PLAYER));
        }


        // 戦闘ループ 
        while(true){
            // 技をランダムで仕込む
            Random ran = new Random();

            // 技行使とダメージ判定
            int damage = orderPlayer.get(FIRST_PLAYER).selectAttack(ran.nextInt(ACTION_COUNT_MAX), orderPlayer.get(SECOND_PLAYER));
            orderPlayer.get(SECOND_PLAYER).decreaseHp(damage);

            // 状態異常判定
            System.out.println();
            System.out.println(orderPlayer.get(FIRST_PLAYER).getName() +": " + orderPlayer.get(FIRST_PLAYER).getCondition());
            System.out.println(orderPlayer.get(SECOND_PLAYER).getName() +": " + orderPlayer.get(SECOND_PLAYER).getCondition());
            System.out.println();

            // 死亡判定
            if(orderPlayer.get(SECOND_PLAYER).isDead()){
                System.out.println();
                System.out.printf(EnumText.DEAD_TEXT.getText(), orderPlayer.get(SECOND_PLAYER).getName());
                break;
            }

            // 先攻後攻を入れ替える
            Player tempPlayer = orderPlayer.get(FIRST_PLAYER);
            orderPlayer.set(FIRST_PLAYER, orderPlayer.get(SECOND_PLAYER));
            orderPlayer.set(SECOND_PLAYER, tempPlayer);
        }

        // 2. の最後のダイアログ
        Dialogue.showStartSettingLastText();


        /* --- 3. 締め --- */
        // 勝者の決定
        // ステータス表示
        Dialogue.showStatusText(orderPlayer.get(FIRST_PLAYER));
        Dialogue.showStatusText(orderPlayer.get(SECOND_PLAYER));
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
    
    public static void main(String[] args) {
        Progress p = new Progress();

        p.mainProgress();

    }
}
