import java.util.Random;

/*
 * 食べ物のクラス
 * 
 */
public class EatItem {

    private final int RANDOM_MAX = 101;

    private String itemName; // アイテム名
    private int dangerLevel; // 危険度
    private int expectedHeelingHp; // 食べたときのHP回復量
    private String causeOfDeath; // 死因

    public EatItem(
          String itemName, int dangerLevel, int expectedHeelingHp, String causeOfDeath
        ) {
        this.itemName = itemName;
        this.dangerLevel = dangerLevel;
        this.expectedHeelingHp = expectedHeelingHp;
        this.causeOfDeath = causeOfDeath;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getDangerLevel() {
        return this.dangerLevel;
    }

    public int getExpectedHeelingHP() {
        return this.expectedHeelingHp;
    }

    public String getCauseOfDeath() {
        return this.causeOfDeath;
    }

    /**
     * 食べることができたかどうかの判定
     * dangerLevelと乱数の値で判定を行う
     * @return true:食べることができた / false:食べることができなかった
     */
    public boolean canEat() {
        Random ran = new Random();
        
        return ran.nextInt(RANDOM_MAX)- this.dangerLevel >= 0;
    }
}