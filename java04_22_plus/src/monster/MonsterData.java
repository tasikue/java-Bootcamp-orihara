package monster;

import java.util.Random;

/**
 * モンスターの定数値保持クラス
 */
public enum MonsterData {
    
    // 定数
    ZAKOMON("ザコモン", 30, 20, 20, 30, 72),
    HUTSUMON("フツモン", 50, 20, 30, 30, 50),
    TSUYOMON("ツヨモン", 100, 50, 30, 25, 28),
    BOSSMON("ボスモン", 100, 50, 50, 10, 25),
    RAREMON("レアモン", 150, 100, 100, 5, 14);

    // 変数
    private String name;
    private int hpValue;
    private int powerValue;
    private int defenseValue;
    private int encountRate;
    private int captureRate;

    // コンストラクタ
    MonsterData(String name, int hpValue, int powerValue, int defenseValue, int encountRate, int captureRate){
        this.name = name;
        this.hpValue = hpValue;
        this.powerValue = powerValue;
        this.defenseValue = defenseValue;
        this.encountRate = encountRate;
        this.captureRate = captureRate;
    }

    public String getName(){
        return name;
    }
    public int getHpValue(){
        return hpValue;
    }
    public int getPowerValue(){
        return powerValue;
    }
    public int getDefenceValue(){
        return defenseValue;
    }
    public int getEncountRate(){
        return encountRate;
    }
    public int getCaptureRate(){
        return captureRate;
    }

    /** 
     * 重みづけランダムでセットしたモンスターを出力する
     * @return ランダムなMonsterのEnum
     */
    public static MonsterData getRandomMonsterData(){
        Random random = new Random();

        // 重みづけのために遭遇率の合計値を求める
        int totalEncountRate = 0;
        for(MonsterData monsterData : MonsterData.values()){
            totalEncountRate += monsterData.encountRate;
        }

        // 重みづけを行いランダム出力
        int rate = random.nextInt(totalEncountRate);
        for(MonsterData monsterData : MonsterData.values()){
            if(rate < monsterData.encountRate){
                return monsterData;
            }
            rate -= monsterData.encountRate;
        }

        return null;
    }
}
