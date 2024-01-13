import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/*
 * 食べ物を管理するクラス
 * 
 */
public class EatItemManager {
    
    private static List<EatItem> eatItemList = new ArrayList<>();

    // 出現する食べ物のリスト
    private static void initialEatItem(){
        eatItemList.add(new EatItem("毒蛇", 15, 30, "毒蛇の毒に負けた…"));
        eatItemList.add(new EatItem("漂流物（缶詰）", 30, 50, "歯では開けられなかった。歯が全部折れて出血死…"));
        eatItemList.add(new EatItem("流木", 8, 20, "バイキンだらけだった…"));
        eatItemList.add(new EatItem("落ち葉", 5, 20, "口の中の水分を全部持っていかれた…"));
        eatItemList.add(new EatItem("毒々しいキノコ", 10, 30, "笑いが止まらず疲れて死んだ…"));
        eatItemList.add(new EatItem("カラフルフルーツ", 5, 30, "種が喉に詰まった…"));
    }

    // ランダムで選んでどれか一つを渡す
    public static EatItem getDinner(){
        Random ran = new Random();
        initialEatItem();
        
        return eatItemList.get(ran.nextInt(eatItemList.size()));
    }
}
