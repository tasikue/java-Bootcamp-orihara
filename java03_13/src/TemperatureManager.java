import java.util.Random;

public class TemperatureManager {

    public static void main(String[] args) {

        final int DIFF_SETTING = 6;
        final int MIN_TEMPERATURE = 2;
        final int MAX_TEMPERATURE = 11;
        
        int nowTemperature = 7;
        
        Temperature aichiTemp =
            new Temperature(
                MIN_TEMPERATURE, MAX_TEMPERATURE, nowTemperature
            );
        
        aichiTemp.showCurrentStatus();
        
        while (aichiTemp.isInRange()) {
            aichiTemp.addChange(DIFF_SETTING);
            aichiTemp.showNowAndCurrentChange();
        }
    }
}
class Temperature {
    private static Random rand = new Random();
    public final int MIN;
    public final int MAX;
    public int now;
    public int currentChange;
    
    public Temperature(int min, int max, int now) {
        this.MIN = min;
        this.MAX = max;
        this.now = now;
    }

    public void showNowAndCurrentChange() {
        System.out.printf(
            "現在の気温: %d (差: %d) %n",
            this.now, this.currentChange
        );
    }
    
    public void addChange(int diffSetting) {
        this.currentChange = this.getChange(diffSetting);
        this.now += this.currentChange;
    }
    
    public void showCurrentStatus() {
        System.out.printf(
            "設定温度=( 最低: %d, 最高: %d ) %n",
            this.MIN, this.MAX
        );
        System.out.printf("現在の気温: %d %n", this.now);
        System.out.println("-----");
    }
    
    public int getChange(int diffSetting) {
        int sign = rand.nextBoolean() ? 1 : -1;  // プラス・マイナス符号
        return rand.nextInt(diffSetting) * sign;
    }

    public boolean isInRange(){
        return MIN <= now && now <= MAX;
    }
}
