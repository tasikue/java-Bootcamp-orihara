import java.util.List;
import java.util.ArrayList;

/**
 * Queue
 * javabootcamp04-10 課題2
 */

public class Stack {
    
    List<String> list = new ArrayList<>();
    private int endIndex;

    public Stack(){
        endIndex = 0;
    }

    public void push(String text){
        list.add(endIndex, text);
        endIndex++;
    }

    // 何もpushされてなかった時のエラー処理を含む
    public String pop(){
        try{
            return list.get(--endIndex);
        } catch(IndexOutOfBoundsException e) {
            ++endIndex;
            return "（値がありません．）";
        }
    }
}
