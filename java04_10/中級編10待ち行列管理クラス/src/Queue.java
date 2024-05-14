import java.util.List;
import java.util.ArrayList;

/**
 * Queueクラス
 * javabootcamp04-10 課題1・4
 * キューに文字列を追加しFIFO方式で取り出すクラス
 * @author orihara
 * @version 1.1
 */

 public class Queue {

    // ★スタック同様になくして書いてみましょう　
    /** キューの先頭のインデックス */
    private int firstIndex;

    // ★フィールは基本的に「private」にしましょう
    /** キューに入る文字列を保持するリスト */
    List<String> stringList = new ArrayList<>();
    /** stringListに対応する文字列の優先度を保持するリスト */
    List<Integer> priorityList = new ArrayList<>();

    /**
     * 先頭インデックスの初期化
     */
    public Queue(){
        firstIndex = 0;
    }

    /**
     * 文字列をキューの最後に追加する
     * @param text 追加する文字列
     */
    public void push(String text){
        stringList.add(text);
        priorityList.add(0);
    }

    /**
     * 文字列とその優先度を追加する
     * 優先度によって追加される位置が決定する
     * @param text 追加する文字列
     * @param priority 文字列の優先度
     */
    public void push(String text, int priority){
        int index = getAddIndexComparePriority(priority);

        stringList.add(index, text);
        priorityList.add(index, priority);
    }

    // ★取り出した場合に要素の削除ができていません。
    /**
     * 入力されていた文字列を前から取り出す
     * 何もpushされてなかった時のエラー処理を含む
     * @return 入力されていた文字列
     */
    public String pop(){
        try {
            return stringList.get(firstIndex++);
        } catch(IndexOutOfBoundsException e) {
            firstIndex--;
            return "（値がありません．）";
        }
    }

    /**
     * 優先度を比較して挿入位置を出力する処理
     * @param priority 優先度
     * @return 追加する位置
     */
    private int getAddIndexComparePriority(int priority){

        for(int i=priorityList.size()-1; i>=firstIndex; i--){
            if(priorityList.get(i) >= priority){
                return i+1;
            }
        }

        return firstIndex;
    }
}