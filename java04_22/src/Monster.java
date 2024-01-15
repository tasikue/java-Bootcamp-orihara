import java.util.Random;

/**
 * モンスターの情報クラス
 * @author orihara
 * @version 1.0
 */
public class Monster {
    
    /** 確立最大値 */
    final int RANDOM_MAX = 101;
    private String name;
    private int hpValue;
    private int powerValue;
    private int defenseValue;
    private int encountRate;
    private int captureRate;

    /**
     * 
     * @param name 名前
     * @param hpValue HP
     * @param powerValue 攻撃
     * @param defenseValue 防御
     * @param encountRate 出現率
     * @param captureRate 捕獲成功率
     */
    public Monster(
            String name,
            int hpValue,
            int powerValue,
            int defenseValue,
            int encountRate,
            int captureRate){
        this.name = name;
        this.hpValue = hpValue;
        this.powerValue = powerValue;
        this.defenseValue = defenseValue;
        this.encountRate = encountRate;
        this.captureRate = captureRate;
    }

    public String getName(){
        return this.name;
    }
    public int getHpValue() {
        return this.hpValue;
    }
    public int getPowerValue() {
        return this.powerValue;
    }
    public int getDefenceValue() {
        return this.defenseValue;
    }
    public int getEncountRate() {
        return this.encountRate;
    }
    public int getCaptureRate() {
        return this.captureRate;
    }

    /**
    * 捕獲ポイントを取得（式：(HP+攻撃+防御)*10）
    * @return 捕獲ポイント
    */
    public int calcCaputuredPoint() {
        return (this.hpValue + this.powerValue + this.defenseValue) * 10;
    }

    /**
    * 捕獲できたかどうかの判定を行う
    * @param correctValue 捕獲率の補正値
    * @return true: 捕獲成功 / false: 捕獲失敗
    */
    public boolean canCaputured(int correctValue) {
        Random ran = new Random();

        return (this.captureRate + correctValue) - ran.nextInt(RANDOM_MAX) >= 0;
    }
}
