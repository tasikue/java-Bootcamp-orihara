/*
 * javabootcamp04-13 ランキング管理クラス
 * 課題2
 * 
 * Score.java
 */

public class Score {

    // 変数
    private int point;
    private String name;
    
    // コンストラクタ
    public Score(int point, String name){
        this.point = point;
        this.name = name;
    }

    /**
     * pointを出力する
     * @return point
     */
    public int getPoint(){
        return this.point;
    }

    /**
     * pointを比較し等しいときnameを足した文字列を出力する
     * @param strPoint 文字列のpoint
     * @return name + point の文字列
     */
    public String getNameAndPoint(String strPoint){

        // ここのpointと入力したpointを比較
        if(String.valueOf(this.point).equals(strPoint)){
            return String.format("%s %d", this.name, this.point);
        }
        return null;
    }
}
