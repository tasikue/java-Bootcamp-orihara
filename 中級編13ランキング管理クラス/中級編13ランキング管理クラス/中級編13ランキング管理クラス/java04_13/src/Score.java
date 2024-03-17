/*
 * javabootcamp04-13 ランキング管理クラス
 * 課題2
 * 
 * Score.java
 */

public class Score {

    // ★JavaDocコメントをお願いします
    // 変数
    private int point;
    private String name;
    
    // コンストラクタ
    public Score(int point, String name){
        this.point = point;
        this.name = name;
    }

    // ★getterのコメントには「〇〇を取得」などをよく見かけます
    /**
     * pointを出力する
     * @return point
     */
    public int getPoint(){
        return this.point;
    }

    // ★クラスの使いまわしがしやすいように
    //   nameを取得するためのgetName()メソッドだけを作って、
    //   Rankingクラスで表示方法を指定するのが良いです
    //   ※メソッドをある程度汎用的にしておくと良いです
    /**
     * pointを比較し等しいときnameを足した文字列を出力する
     * @param strPoint 文字列のpoint
     * @return name + point の文字列
     */
    public String getNameAndPoint(String strPoint){

        // ★同じpointの場合は衝突を起こす
        // ここのpointと入力したpointを比較
        if(String.valueOf(this.point).equals(strPoint)){
            return String.format("%s %d", this.name, this.point);
        }
        return null;
    }
}
