import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * javabootcamp 04-16
 * 課題2
 * TrumpManager
 */

public class TrumpManager {

    private List<Trump> trumps = new ArrayList<>();
    private final int MARK_NUMBER_MAX = 4;
    private final int CARD_NUMBER_MAX = 13;

    // トランプカードの生成
    public void reset(){
        for(int i=1; i<=MARK_NUMBER_MAX; i++){
            for(int j=1; j<=CARD_NUMBER_MAX; j++){
                trumps.add(new Trump(i, j));
            }
        }
    }

    // カードをシャッフルする
    public void shuffle(){
        Collections.shuffle(trumps);
    }

    // カードを一枚引く
    public Trump draw(){
        Trump target = trumps.get(0);

        trumps.remove(0);
        return target;
    }
}