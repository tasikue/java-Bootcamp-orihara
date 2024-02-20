package com.name.battler;

import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

public class Progress {

    Scanner scan;

    /**
     * メイン進行
     */
    public void mainProgress(){
        // 最初のダイアログ
        Dialogue.showStartSettingText();


        // プレイヤーネームのためのリストを用意
        List<String> playerName = new ArrayList<>();

        // プレイヤーの名前を2つ作成
        playerName.add(createPlayerName());
        playerName.add(createPlayerName());

        // ここでscanを閉じる
        scan.close();

        // プレイヤーを作成

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
