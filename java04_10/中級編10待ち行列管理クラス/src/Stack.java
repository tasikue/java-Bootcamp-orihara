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
    
    // ★フィールは基本的に「private」にしましょう
    /** 文字列を保持するリスト */
    List<String> list = new ArrayList<>();
    // ★リストのsize()を使うことで代用できます。
    //   増減を手動でやらなくて済むので楽です
    /** スタックの最後のインデックス */
    private int lastIndex;

    /**
     * 最後のインデックスの初期化
     */
    public Stack(){
        lastIndex = 0;
    }

    // ★「スタックに文字列を追加する」などでオッケーです
    //   他の人が使うときに知りたい情報をここに書くイメージです
    /**
     * 文字列を追加しインデックスをずらす
     * @param text 追加する文字列
     */
    public void push(String text){
        list.add(lastIndex, text);
        lastIndex++;
    }

    // ★コメントは「最後にスタックに追加した要素を取り出す」などが良い
    //   また、returnのコメントに要素が存在しない場合はnullを返すなどの記述があると尚更良しです。
    //   そうすれば使う人は返ってくるものについて簡単に認識できます
    // ★要素の削除ができていません
    /**
     * 入力されていた文字を後ろから取り出す
     * 何もpushされてなかった時のエラー処理を含む
     * @return 取り出した文字列
     */
    public String pop() {
        // ★プログラムの書き方を変えれば発生させなくて済む例外は極力回避しましょう
        try{
            return list.get(--lastIndex);
        } catch(IndexOutOfBoundsException e) {
            ++lastIndex;
            // ★返せるものがない場合はnullを返すか例外を返すのが一般的です
            //   理由としては受け取った側が検知しやすいからです
            //   「nullが帰ってきたら失敗ね！」と判定しやすいです
            //   今回のように他の文字列を返してしますと
            //   その値がリストに入ってたものかリストが空だったかが分からないです
            // ★注意としてはnullを返す場合は
            //   スタックにnullは入れれないようにする制御は必要です
            //   nullも入れたい場合は、例外を返すと良い
            return "（値がありません．）";
        }
    }

    // ★例
    // /**
    //  * 最後にスタックに追加した要素を取り出す
    //  * @return 最後にスタックに追加した要素を返す。
    //  *         ただし、スタックが空の場合は{@code null}を返す。
    //  */
    // public String pop(){
    //     if(list.isEmpty()){
    //         return null;
    //     }
    //     int lastIndex = list.size() - 1;
    //     return list.remove(lastIndex);
    // }
}
