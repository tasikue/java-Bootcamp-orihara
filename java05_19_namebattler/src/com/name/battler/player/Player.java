package com.name.battler.player;

import com.name.battler.player.action.Attack;

/**
 * プレイヤーの基底クラス
 */
public class Player implements Attack{

    // プレイヤーステータス
    private String job; // 職業
    private int hp; // 体力
    private int mp; // マジックパワー
    private int str; // 攻撃力
    private int def; // 防御力
    private int luck; // 幸運度
    private int agi; // 素早さ
    private String condition; // 状態異常

    protected Player(){
        condition = "通常";
    }

    protected String getCondition(){
        return condition;
    }

    /**
     * 通常攻撃を行うメソッド
     */
    public void doNormalAttack(){
        System.out.println("");
    }
}
