package com.name.battler.player.action;

/**
 * 状態異常の定数をまとめる列挙型
 */
public enum Condition {
    
    // 定数
    /** 通常状態 */
    NORMAL(0, "元気", 0),
    /** どく状態 */
    POISON(1, "どく", 20),
    /** まひ状態 */
    PALIZE(2, "麻痺", 0);

    // 変数
    /** 状態異常ID */
    private int id;
    /** 状態異常名 */
    private String name;
    /** 状態異常によるダメージ */
    private int damage;

    /**
     * 状態異常のIDと名前と受けるダメージを入力するコンストラクタ
     * @param id ID
     * @param name 状態異常名
     * @param damage 状態異常によるダメージ
     */
    Condition(int id, String name, int damage){
        this.id = id;
        this.name = name;
        this.damage = damage;
    }

    /** --- メソッド --- */
    /**
     * 状態異常のIDを取得する処理
     * @return 状態異常のID
     */
    public int getId(){
        return this.id;
    }

    /**
     * 状態異常の名前を取得する処理
     * @return 状態異常の名前
     */
    public String getName(){
        return this.name;
    }

    /**
     * 状態異常のダメージを取得する処理
     * @return 状態異常のダメージ
     */
    public int getDamage(){
        return this.damage;
    }
}