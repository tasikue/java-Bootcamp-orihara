package com.name.battler.player.enumplayer;

import com.name.battler.setting.Range;

/**
 * 技の定数をまとめる列挙型
 */
public enum EnumAction {

    // 定数
    /** 通常攻撃 */
    ATTACK(0, "こうげき", 0, 0, 0),
    /** 炎攻撃 */
    FIRE(1, "ファイア", 10, 10, 30),
    /** 電撃攻撃 */
    THUNDER(2, "サンダー", 20, 10, 30),
    /** 回復呪文 */
    HEEL(3, "ヒール", 20, -50, -50),
    /** 毒呪文 */
    POISON(4, "どく", 10, 0, 0),
    /** 麻痺呪文 */
    PALIZE(5, "まひ", 10, 0, 0);

    // 変数
    /** 技ID */
    private int id;
    /** 技名 */
    private String name;
    /** 技の消費MPコスト */
    private int cost;
    /** 技のダメージ範囲 */
    private Range damageRange;

    /**
     * 技のIDと技名を入力するコンストラクタ
     * @param id ID
     * @param name 技名
     */
    EnumAction(int id, String name, int cost, int damageMin, int damageMax){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.damageRange = new Range(damageMin, damageMax);
    }
    
    /* --- メソッド --- */
    /**
     * 技idを取得する処理
     * @return 技ID
     */
    public int getId(){
        return this.id;
    }

    /**
     * 技名を取得する処理
     * @return 技名
     */
    public String getName(){
        return this.name;
    }

    /**
     * 魔法のMP消費コストを取得する処理
     * @return
     */
    public int getCost(){
        return this.cost;
 
    }

    /**
     * 技の攻撃力範囲を取得する処理
     * @return 技のダメージ範囲
     */
    public Range getDamageRange(){
        return this.damageRange;
    }
}