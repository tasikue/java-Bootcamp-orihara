package com.name.battler.player.enumplayer;

/**
 * ジョブの定数をまとめるクラス
 */
public enum EnumJob {
    
    // 定数
    FIGHTER(0, "戦士"),
    WIZARD(1, "魔法使い"),
    PRIEST(2, "僧侶");

    // 変数
    int id;
    String name;

    /**
     * ジョブのIDとジョブ名を入力するコンストラクタ
     * @param id ID
     * @param name ジョブ名
     */
    EnumJob(int id, String name){
        this.id = id;
        this.name = name;
    }

    /** --- メソッド ---*/
    /**
     * ジョブIDを出力する処理
     * @return ジョブID
     */
    public int getId(){
        return this.id;
    }

    /**
     * ジョブの名前を出力する処理
     * @return ジョブの名前
     */
    public String getName(){
        return this.name;
    }
}