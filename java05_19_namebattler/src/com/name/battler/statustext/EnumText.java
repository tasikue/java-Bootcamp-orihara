package com.name.battler.statustext;

public enum EnumText {
    
    // 列挙
    START_SETTING_TEXT_01("2体の魔物を生み出した ...!"),
    START_SETTING_TEXT_02("名前を付けてあげよう!"),
    CREATE_PLAYER_NAME_ATTENTION_TEXT("もう一度入力してください"),
    NAME_PUT_TEXT("%d 体目の名前は... "),
    LINE_TEXT("------------------------------"),
    STATUS_TEXT_01("%s \n"),
    STATUS_TEXT_02("職業: %s | 技名:  \n"),
    STATUS_TEXT_03("HP: %d, MP: %d, こうげき: %d, ぼうぎょ: %d, こううん: %d, すばやさ: %d \n"),
    BATTLE_START_TEXT_01("2体の魔物はにらみ合っている..."),
    BATTLE_START_TEXT_02("魔物たちは戦いだした！"),
    START_SETTING_LAST_TEXT("\n"),
    BATTLE_ATTACK_TEXT01("%s のこうげき ！ \n"),
    BATTLE_ATTACK_TEXT02("%s は %d のダメージを受けた！ \n"),
    BATTLE_ATTACK_MISS_TEXT("しかし こうげきは外れた！\n"),
    CRITICAL_TEXT("SMAAAAAAAAASH!!!! \n"),
    POISON_TEXT("%s の毒攻撃！ \n"),
    PALAIZE_TEXT("%s の麻痺攻撃！ \n"),
    HEEL_TEXT("%s の回復！ \n"),
    HEEL_TEXT02("%s は %d 回復した ！ \n"),
    HEEL_TEXT03("MPが足りない！\n"),
    DEAD_TEXT("%s は崩れて消滅した...\n"),
    FIRE_TEXT("%s はファイヤを唱えた！\n"),
    THUNDER_TEXT("%s はサンダーを唱えた！\n");

    private String text;

    EnumText(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}
