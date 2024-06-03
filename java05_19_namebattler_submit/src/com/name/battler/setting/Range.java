package com.name.battler.setting;

import java.util.Random;

/**
 * 2つの数値を範囲とするクラス
 */
public class Range {
    
    // 変数
    private int min;
    private int max;

    /**
     * 数値範囲の最大最少を入力させるコンストラクタ
     * @param min 範囲を最小値
     * @param max 範囲の最大値
     */
    public Range(int min, int max){     
        this.min = min;
        this.max = max;
    }

    /* --- メソッド --- */
    /**
     * 最小値を出力する処理
     * @return 最小値
     */
    public int getMin(){
        return this.min;
    }

    /**
     * 最大値を出力する処理
     * @return 最大値
     */
    public int getMax(){
        return this.max;
    }

    /**
     * 範囲内からランダムに値を選び出力する処理
     * @return min~maxの範囲内のランダムな値
     */
    public int getRandomValue(){
        Random ran = new Random();
        
        // 最大値と最小値が同じとき
        if(this.min == this.max){
            return this.min;
        }

        // ランダム
        return ran.nextInt((this.max - this.min)) + this.min;
    }
}