/**
 * 捕獲玉情報クラス
 * @author orihara
 * @version 1.0
 */
public class CaptureBall {

    private String name;
    private int correctValue;
    private int count;
    
    /**
     * 
     * @param name 名称
     * @param correctValue 捕獲率の補正値
     * @param count 所持数
     */
    CaptureBall(String name, int correctValue, int count) {
        this.name = name;
        this.correctValue = correctValue;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }
    public int getCorrectValue() {
        return this.correctValue;
    }
    public int getCount() {
        return this.count;
    }

    /**
    * 捕獲玉を使用する
    */
    public void use() {
        this.count--;
    }
}