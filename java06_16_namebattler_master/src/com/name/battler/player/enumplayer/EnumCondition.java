package com.name.battler.player.enumplayer;

/**
 * 状態異常の定数をまとめる列挙型
 */
public enum EnumCondition {
    
    // 定数
    NORMAL(0, "元気", 0), // 通常状態
    POISON(1, "どく", 20), // どく状態 
    PALIZE(2, "麻痺", 0); // まひ状態

    // 変数
    int conditionId;
    String conditionName;
    int conditionDamage;

    EnumCondition(int conditionId, String conditionName, int conditionDamage){
        this.conditionId = conditionId;
        this.conditionName = conditionName;
        this.conditionDamage = conditionDamage;
    }

    // メソッド
    /**
     * 状態異常のIDを得る処理
     * @return 状態異常のID
     */
    public int getConditionId(){
        return this.conditionId;
    }

    /**
     * 状態異常の名前を得る処理
     * @return 状態異常の名前
     */
    public String getConditionName(){
        return this.conditionName;
    }

    /**
     * 状態異常のダメージを得る処理
     * @return 状態異常のダメージ
     */
    public int getConditionDamage(){
        return this.conditionDamage;
    }
}
