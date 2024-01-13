
/*
 * 食べたものを記録するクラス
 * 
 */

public class EatItemHistory {

    private int day;
    private int hp;
    private EatItem eatItem;
    private boolean doEat;

    EatItemHistory(int day, int hp, EatItem eatItem, boolean doEat){
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
