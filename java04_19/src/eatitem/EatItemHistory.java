package eatitem;

/*
 * 食べたものを記録するクラス
 */
public class EatItemHistory {

    // 変数
    /** 日数 */
    private int day;
    /** プレイヤーHP */
    private int hp;
    /** 食べ物クラス */
    private EatItem eatItem;
    /** 食べたかどうか */
    private boolean doEat;

    /**
     * 食べ物を記録するためのコンストラクタ
     * @param day 日数
     * @param hp プレイヤーHP
     * @param eatItem 食べ物
     * @param doEat 食べたかどうか
     */
    public EatItemHistory(int day, int hp, EatItem eatItem, boolean doEat){
        this.day = day;
        this.hp = hp;
        this.eatItem = eatItem;
        this.doEat = doEat;
    }

    public int getDay(){
        return day;
    }

    public int getHp(){
        return this.hp;
    }

    public String getEatItemName(){
        return eatItem.getItemName();
    }

    public int getDangerLevel(){
        return eatItem.getDangerLevel();
    }

    public boolean getDoEat(){
        return doEat;
    }
}
