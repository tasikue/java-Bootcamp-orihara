import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * RandomQueueクラス
 * javabootcamp04-10 課題3
 * キューに文字列を追加しランダムで取り出す
 * @author orihara
 * @version 1.1
 */

public class RandomQueue {
    
    // ★フィールは基本的に「private」にしましょう
    /** 文字列を保持するリスト */
    List<String> stringList = new ArrayList<>();

    /**
     * 文字列をキューに追加する
     * @param text 追加する文字列
     */
    public void push(String text){
        stringList.add(text);
    }

    // ★コメントは「キューからランダムな要素を取り出す」などが良い
    //   中のアルゴリズムは基本説明する必要がないです
    /**
     * どれをpopするかランダムで決めてListから取り除く処理
     * @return 取り出した文字列
     */
    public String pop(){
        Random ran = new Random();
        // ★targetIndexなどにすると他も命名しやすいかも？（私の主観）
        int target = ran.nextInt(stringList.size());

        // ★Stackでサンプルとして書いたプログラムのように
        //   return stringList.remove(target);
        //   と書いても上手く行きます。
        String tempTargetText = stringList.get(target);
        stringList.remove(target);

        return tempTargetText;
    }
}
