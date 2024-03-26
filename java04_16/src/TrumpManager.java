import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

/**
 * javabootcamp 04-16
 * 課題2
 * TrumpManager
 */
public class TrumpManager {

    // 変数
    /** トランプを格納するリスト */
    private List<Trump> trumps = new ArrayList<>();
    /** 数値の最大個数 */
    private final int CARD_COUNT_MAX = 13;

    /** 
     * トランプをリセットする(残り52枚にする)
     */
    public void reset(){
        for(int i=1; i<=Mark.values().length; i++){
            for(int j=1; j<=CARD_COUNT_MAX; j++){
                trumps.add(new Trump(i, j));
            }
        }
    }

    /**
     * 残りのトランプをシャッフルする
     */
    public void shuffle(){
        Collections.shuffle(trumps);
    }

    /**
     * 先頭のカードを一枚引く
     * @return Tramp
     */
    public Trump draw(){
        return trumps.remove(0);
    }
}