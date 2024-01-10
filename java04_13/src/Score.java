/*
 * javabootcamp04-13 ランキング管理クラス
 * 課題2
 * 
 * Score.java
 */

public class Score {

    private int point;
    private String name;
    
    public Score(int point, String name){
        this.point = point;
        this.name = name;
    }

    public int getPoint(){
        return point;
    }

    public String getNameAndPoint(String strPoint){
        if(String.valueOf(this.point).equals(strPoint)){
            return String.format("%s %d", this.name, this.point);
        }
        return null;
    }
}
