package com.name.battler.statustext;

import java.util.List;

import com.name.battler.player.Party;
import com.name.battler.player.Player;

/**
 * まとまったテキストを出力するクラス
 */
public class Dialogue {
    
    /** 始めのテキスト */
    public static void showStartSettingText(){
        message(EnumText.START_SETTING_TEXT_01.getText());
        messageln(EnumText.START_SETTING_TEXT_02.getText());
    }

    /** 始めの最後のテキスト、全パーティの表示 */
    public static void showStartSettingLastText(List<Party> partyList){
        messageln("");
        for(int i=0; i<partyList.size(); i++){
            System.out.format(EnumText.START_SETTING_LAST_TEXT01.getText(), i + 1);
            for(int j=0; j<Party.getMaxPartyCount(); j++){
                Player tempPlayer = partyList.get(i).getMembers().get(j);

                System.out.format("%s: ", tempPlayer.getName());
                System.out.format("%s  ", tempPlayer.getJobName());
            }
            messageln("");
        }
        messageln("");
    }

    /** ステータス表示のテキスト */
    public static void showStatusText(Player player){
        message(EnumText.LINE_TEXT.getText());
        System.out.format(EnumText.STATUS_TEXT_01.getText(), player.getName());
        System.out.format(EnumText.STATUS_TEXT_02.getText(), player.getJobName());
        System.out.format(EnumText.STATUS_TEXT_03.getText(), player.getHp(), player.getMp(), player.getStr(), player.getDef(), player.getLuck(), player.getAgi());
        message(EnumText.LINE_TEXT.getText());
    }

    /** バトルフェイズ開始のテキスト */
    public static void showStartBattleText(){
        message(EnumText.BATTLE_START_TEXT_01.getText());
        messageln(EnumText.BATTLE_START_TEXT_02.getText());
    }

    /** 死亡時のテキスト */
    public static void showDeadPlayerText(Player player){
        message("");
        System.out.format(EnumText.DEAD_TEXT.getText(), player.getLongName());
        messageln("");
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
