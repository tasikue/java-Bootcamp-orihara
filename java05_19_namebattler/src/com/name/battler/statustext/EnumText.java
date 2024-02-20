package com.name.battler.statustext;

public enum EnumText {
    
    // 列挙
    START_SETTING_TEXT_01("2体の魔物を生み出した ...!"),
    START_SETTING_TEXT_02("名前を付けてあげよう!"),
    CREATE_PLAYER_NAME_ATTENTION_TEXT("もう一度入力してください");

    private String text;

    EnumText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
