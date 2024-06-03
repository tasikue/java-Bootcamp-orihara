package com.name.battler.player.job;

/**
 * ジョブの定数をまとめるクラス
 */
public enum Job {
    
    // 定数
    /** 戦士 */
    FIGHTER(0, "戦士"),
    /** 魔法使い */
    WIZARD(1, "魔法使い"),
    /** 僧侶 */
    PRIEST(2, "僧侶"),
    /** 勇者 */
    HERO(3, "勇者");

    // 変数
    /** ジョブID */
    private int id;
    /** ジョブ名 */
    private String name;

    /**
     * ジョブのIDと名前を入力するコンストラクタ
     * @param id ID
     * @param name ジョブ名
     */
    Job(int id, String name){
        this.id = id;
        this.name = name;
    }

    /** --- メソッド ---*/
    /**
     * ジョブIDを取得する処理
     * @return ジョブID
     */
    public int getId(){
        return this.id;
    }

    /**
     * ジョブの名前を取得する処理
     * @return ジョブの名前
     */
    public String getName(){
        return this.name;
    }
}