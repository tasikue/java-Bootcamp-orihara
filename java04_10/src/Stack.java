import java.util.List;
import java.util.ArrayList;

/**
 * Stackクラス
 * javabootcamp04-10 課題2
 * スタックに文字列を追加しFILO方式で取り出すクラス
 * @author orihara
 * @version 1.1
 */

public class Stack {
    
    /** 文字列を保持するリスト */
    List<String> list = new ArrayList<>();
    /** スタックの最後のインデックス */
    private int lastIndex;

    /**
     * 最後のインデックスの初期化
     */
    public Stack(){
        lastIndex = 0;
    }

    /**
     * 文字列を追加しインデックスをずらす
     * @param text 追加する文字列
     */
    public void push(String text){
        list.add(lastIndex, text);
        lastIndex++;
    }

    /**
     * 入力されていた文字を後ろから取り出す
     * 何もpushされてなかった時のエラー処理を含む
     * @return 取り出した文字列
     */
    public String pop(){
        try{
            return list.get(--lastIndex);
        } catch(IndexOutOfBoundsException e) {
            ++lastIndex;
            return "（値がありません．）";
        }
    }
}
