package com.name.battler.setting;

/**
 * 2つの数値を範囲とするクラス
 */
public class Range {
    
    // 変数
    int max;
    int min;

    /**
     * 数値範囲の最大最少を入力させるコンストラクタ
     * @param max 範囲の最大値
     * @param min 範囲を最小値
     */
    public Range(int max, int min){
        this.max = max;
        this.min = min;
    }

    /* --- メソッド --- */    
    /**
     * 最大値を出力する処理
     * @return 最大値
     */
    public int getMax(){
        return this.max;
    }

    /**
     * 最小値を出力する処理
     * @return 最小値
     */
    public int getMin(){
        return this.min;
    }

    /**
     * 範囲内からランダムに値を選び出力する処理
     * @return 範囲内のランダムな値
     */
    public int getRandomValue(){
        
        // 最大値と最小値が同じとき
        if(this.min == this.max){
            return this.min;
        }

        return 0;
    }
}
