package com.name.battler.statustext;

/**
 *  表示するテキストを定数で保持する列挙型
 */
public enum EnumText {
    
    // 列挙
    START_SETTING_TEXT_01("2体の魔物を生み出した ...!"),
    START_SETTING_TEXT_02("名前を付けてあげよう!"),
    CREATE_PLAYER_NAME_ATTENTION_TEXT("もう一度入力してください"),
    SELECT_JOB_ATTENTION_TEXT01("数字で入力してください"),
    SELECT_JOB_ATTENTION_TEXT02("表記してある数字を入力してください"),
    NAME_PUT_TEXT("%d 体目の名前は... "),
    LINE_TEXT("------------------------------"),
    STATUS_TEXT_01("%s \n"),
    STATUS_TEXT_02("職業: %s | \n"),
    STATUS_TEXT_03("HP: %d, MP: %d, こうげき: %d, ぼうぎょ: %d, こううん: %d, すばやさ: %d \n"),
    BATTLE_START_TEXT_01("2体の魔物はにらみ合っている..."),
    BATTLE_START_TEXT_02("魔物たちは戦いだした！"),
    START_SETTING_LAST_TEXT("\n"),
    BATTLE_ATTACK_TEXT01("%s のこうげき ！ \n"),
    BATTLE_ATTACK_TEXT02("%s は %d のダメージを受けた！ \n"),
    BATTLE_ATTACK_MISS_TEXT("しかし こうげきは外れた！\n"),
    CRITICAL_TEXT("SMAAAAAAAAASH!!!! \n"),
    HEEL_TEXT01("%s は HP %d まで回復した ！ \n"),
    DEAD_TEXT("%s は崩れて消滅した...\n"),
    MAGIC_TEXT01("%s は %s を唱えた！\n"),
    MAGIC_TEXT02("MPが足りない！\n"),
    PLAYER_STATUS_TEXT("ジョブID: %d, HP: %d, MP: %d, 攻撃力: %d, 防御力: %d, 幸運度: %d, すばやさ: %d \n"),
    POISON_DAMAGE_TEXT("%s は %s のダメージを受けている ...！ \n"),
    PALIZE_TEXT("%s は %s で苦しんでいる ...！ \n");

    // 変数
    private String text;

    /**
     * テキストを入力するコンストラクタ
     * @param text テキスト
     */
    EnumText(String text){
        this.text = text;
    }

    /**
     * テキストを取得する処理
     * @return テキスト
     */
    public String getText(){
        return this.text;
    }
}
