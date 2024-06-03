package com.name.battler.statustext;

import com.name.battler.player.Player;

/**
 * まとまったテキストを出力するクラス
 */
public class Dialogue {
    
    /** 始めのテキスト */
    public static void showStartSettingText(){
        message(ConstantText.START_SETTING_TEXT_01.getText());
        messageln(ConstantText.START_SETTING_TEXT_02.getText());
    }

    /** 始めの最後のテキスト */
    public static void showStartSettingLastText(){
        message(ConstantText.START_SETTING_LAST_TEXT.getText());
    }

    /** ステータス表示のテキスト */
    public static void showStatusText(Player player){
        message(ConstantText.LINE_TEXT.getText());
        System.out.format(ConstantText.STATUS_TEXT_01.getText(), player.getName());
        System.out.format(ConstantText.STATUS_TEXT_02.getText(), player.getJobName());
        System.out.format(ConstantText.STATUS_TEXT_03.getText(), player.getHp(), player.getMp(), player.getStr(), player.getDef(), player.getLuck(), player.getAgi());
        message(ConstantText.LINE_TEXT.getText());
    }

    /** バトルフェイズ開始のテキスト */
    public static void showStartBattleText(){
        message(ConstantText.BATTLE_START_TEXT_01.getText());
        messageln(ConstantText.BATTLE_START_TEXT_02.getText());
    }

    /**
     * テキストを出力する処理
     * @param text テキスト
     */
    private static void message(String text){
        System.out.format(text + "\n");
    }

    /**
     * テキストを出力する処理（改行）
     * @param text テキスト
     */
    private static void messageln(String text){
        System.out.format(text + "\n\n");
    }
}
