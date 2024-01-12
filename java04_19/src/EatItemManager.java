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
    }
}
