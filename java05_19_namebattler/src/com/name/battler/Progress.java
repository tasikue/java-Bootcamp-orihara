package com.name.battler;

import java.util.Scanner;
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

        // 先攻の攻撃のダイアログ
        System.out.printf("%s のこうげき！ \n", orderPlayer.get(FIRST_PLAYER).getName());

        
        // 先攻が攻撃をしダメージを与える
        int damage = orderPlayer.get(FIRST_PLAYER).doNormalAttack(orderPlayer.get(SECOND_PLAYER));
        orderPlayer.get(SECOND_PLAYER).decreaseHp(damage);

        // ダメージのダイアログ
        System.out.printf("%s は %d のダメージを受けた！ \n", orderPlayer.get(SECOND_PLAYER).getName(), damage);

        // 状態異常判定

        // 死亡判定

        // 先攻の攻撃のダイアログ
        System.out.printf("%s のこうげき！ \n", orderPlayer.get(SECOND_PLAYER).getName());

        // 先攻が攻撃をしダメージを与える
        damage = orderPlayer.get(SECOND_PLAYER).doNormalAttack(orderPlayer.get(FIRST_PLAYER));
        orderPlayer.get(FIRST_PLAYER).decreaseHp(damage);

        // ダメージのダイアログ
        System.out.printf("%s は %d のダメージを受けた！ \n", orderPlayer.get(FIRST_PLAYER).getName(), damage);

        // ダメージ判定&状態異常判定

        // 死亡判定

        // ステータス表示
        Dialogue.showStatusText(orderPlayer.get(FIRST_PLAYER));
        Dialogue.showStatusText(orderPlayer.get(SECOND_PLAYER));


        // 勝者の決定


        /* --- 3. 締め --- */
    }


    /**
     * プレイヤーネームの入力を受け付けそれを出力する
     * @return プレイヤーネーム
     */
    private String createPlayerName(){
        scan = new Scanner(System.in);

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
