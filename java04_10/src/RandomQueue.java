import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * Queue
 * javabootcamp04-10 課題3
 */

public class RandomQueue {
    
    List<String> list = new ArrayList<>();

    public void push(String text){
        list.add(text);
    }

    // どれをpopするかランダムで決めてListから取り除く処理
    public String pop(){
        Random ran = new Random();
        int target = ran.nextInt(list.size());

        String tempTargetText = list.get(target);
        list.remove(target);

        return tempTargetText;
    }
}
