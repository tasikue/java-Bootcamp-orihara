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
    
    /** 文字列を保持するリスト */
    List<String> stringList = new ArrayList<>();

    /**
     * 文字列をキューに追加する
     * @param text 追加する文字列
     */
    public void push(String text){
        stringList.add(text);
    }

    /**
     * どれをpopするかランダムで決めてListから取り除く処理
     * @return 取り出した文字列
     */
    public String pop(){
        Random ran = new Random();
        int target = ran.nextInt(stringList.size());

        String tempTargetText = stringList.get(target);
        stringList.remove(target);

        return tempTargetText;
    }
}
