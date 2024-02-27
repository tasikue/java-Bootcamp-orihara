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

        // 先攻を選択
        

        // 選択された方が攻撃

        // ダメージを受ける＆状態異常判定

        // 死亡判定

        // 後攻を選択

        // ダメージ判定&状態異常判定

        // 死亡判定


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
