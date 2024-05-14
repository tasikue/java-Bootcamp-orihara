package eatitem;

import java.util.Random;

/*
 * 食べ物を管理するクラス
 * 
 */
// ★名前にEnumを付ける必要はないです
public enum EnumEatItem {

    // 定数
    // ★少し特殊な書き方ですね。今のところ、初登場です。
    VIPER(new EatItem("毒蛇", 15, 30, "毒蛇の毒に負けた…")),
    CAN(new EatItem("漂流物（缶詰）", 30, 50, "歯では開けられなかった。歯が全部折れて出血死…")),
    DRIFTWOOD(new EatItem("流木", 8, 20, "バイキンだらけだった…")),
    FALLENLEAVES(new EatItem("落ち葉", 5, 20, "口の中の水分を全部持っていかれた…")),
    MUSHROOM(new EatItem("毒々しいキノコ", 10, 30, "笑いが止まらず疲れて死んだ…")),
    FRUIT(new EatItem("カラフルフルーツ", 5, 30, "種が喉に詰まった…"));

    // 変数
    private EatItem eatItem;

    /**
     * コンストラクタ
     */
    EnumEatItem(EatItem eatItem){
        this.eatItem = eatItem;
    }

    private EatItem getEatItem(){
        return this.eatItem;
    }

    /**
     * ランダムでどれかひとつを返す
     * @return 食べ物EatItem型
     */ 
    public static EatItem getDinner(){
        // 全要素の長さ
        int len = EnumEatItem.values().length;

        // ランダム(列挙個数分)
        Random ran = new Random();
        int randomCount = ran.nextInt(len);
        
        int count = 0;
        // 列挙型全体からどれか一つを返す
        for(EnumEatItem enumEatItem : EnumEatItem.values()){
            if(count == randomCount){
                return enumEatItem.getEatItem();
            }
            count++;
        }
        return null;
    }
}
