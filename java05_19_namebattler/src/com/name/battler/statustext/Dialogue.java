package com.name.battler.statustext;

public class Dialogue {
    
    public static void showStartSettingText(){
        messageln(EnumText.START_SETTING_TEXT_01.getText());
        messageln(EnumText.START_SETTING_TEXT_02.getText());
    }

    private static void messageln(String text){
        System.out.format(text + "\n");
    }
}
