package com.name.battler.player.enumplayer;

/**
 * 技の定数をまとめる列挙型
 */
public enum EnumAction {

    // 定数
    ATTACK(0, "こうげき"), // 通常攻撃
    FIRE(1, "ファイア"), // 炎攻撃
    THUNDER(2, "サンダー"), // 電撃攻撃
    HEEL(3, "ヒール"), // 回復呪文
    POISON(4, "どく"), // 毒呪文
    PALIZE(5, "まひ"); // 麻痺呪文

    // 変数
    int actionId;
    String actionName;

    // コンストラクタ
    EnumAction(int actionId, String actionName){
        this.actionId = actionId;
        this.actionName = actionName;
    }
    
    /**
     * 技名を出力する処理
     * @return 技名
     */
    public String getActionName(){
        return this.actionName;
    }
}
