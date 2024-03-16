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
    int id;
    String name;
    int damage;

    /**
     * 状態異常のIDと状態異常名と状態異常で受けるダメージを入力する
     * @param id ID
     * @param name 状態異常名
     * @param damage 状態異常によるダメージ
     */
    EnumCondition(int id, String name, int damage){
        this.id = id;
        this.name = name;
        this.damage = damage;
    }

    /** --- メソッド --- */
    /**
     * 状態異常のIDを出力する処理
     * @return 状態異常のID
     */
    public int getId(){
        return this.id;
    }

    /**
     * 状態異常の名前を出力する処理
     * @return 状態異常の名前
     */
    public String getName(){
        return this.name;
    }

    /**
     * 状態異常のダメージを出力する処理
     * @return 状態異常のダメージ
     */
    public int getDamage(){
        return this.damage;
    }
}