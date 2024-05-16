package captureball;

/** 
 * ボールの定数の値保持データ
 */
public enum CaptureBallData {

    // 定数
    NORMAL_BALL("ノーマル捕獲玉", 0, 6),
    SUPER_BALL("スーパー捕獲玉", 20, 3),
    MIRACLE("ミラクル捕獲玉", 50, 1);

    // 変数
    private String name;
    private int correctValue;
    private int count;

    // コンストラクタ
    CaptureBallData(String name, int correctValue, int count){
        this.name = name;
        this.correctValue = correctValue;
        this.count = count;
    }

    public String getName(){
        return this.name;
    }
    public int getCorrectValue(){
        return this.correctValue;
    }
    public int getCount(){
        return this.count;
    }
}
