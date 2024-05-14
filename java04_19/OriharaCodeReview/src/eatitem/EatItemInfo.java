package eatitem;

import java.util.Random;

/*
 * 食べ物を管理するクラス
 * 
 */
// ★名前にEnumを付ける必要はないです
public enum EatItemInfo {

    // 定数
    // ★少し特殊な書き方ですね。今のところ、初登場です。
    VIPER("毒蛇", 15),
    CAN("漂流物（缶詰）", 30);

    // 変数
    private String itemName;
    private int dangerLevel;

    /**
     * コンストラクタ
     */
    EatItemInfo(String itemName,int dangerLevel){
        this.itemName = itemName;
        this.dangerLevel = dangerLevel;
    }

    public String getItemName(){
        return itemName;
    }

    public int getDangerLevel(){
        return dangerLevel;
    }

    public static EatItemInfo getRandomItem(){
        Random random = new Random();
        int idx = random.nextInt(EatItemInfo.values().length);

        return EatItemInfo.values()[idx];
    }
}
