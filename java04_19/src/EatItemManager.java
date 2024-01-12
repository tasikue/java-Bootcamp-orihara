import java.util.List;
import java.util.ArrayList;

/*
 * 食べ物を管理するクラス
 * 
 */
public class EatItemManager {
    
    List<EatItem> eatItemList = new ArrayList<>();

    // 食べ物を追加する
    private void setEatItem(){
        eatItemList.add(new EatItem("毒蛇", 15, 30, "毒蛇の毒に負けた…"));
        eatItemList.add(new EatItem("漂流物（缶詰）", 30, 50, "歯では開けられなかった。歯が全部折れて出血死…"));
        eatItemList.add(new EatItem("流木", 8, 20, "バイキンだらけだった…"));
        eatItemList.add(new EatItem("落ち葉", 5, 20, "口の中の水分を全部持っていかれた…"));
        eatItemList.add(new EatItem("毒々しいキノコ", 10, 30, "笑いが止まらず疲れて死んだ…"));
        eatItemList.add(new EatItem("カラフルフルーツ", 5, 30, "種が喉に詰まった…"));
    }
}
