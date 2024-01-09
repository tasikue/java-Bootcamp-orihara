import java.util.List;
import java.util.ArrayList;

/**
 * Queue
 * javabootcamp04-10 課題1・4
 */

 public class Queue {

    private int startIndex;
    List<String> list = new ArrayList<>();
    List<Integer> priorityList = new ArrayList<>();

    public Queue(){
        startIndex = 0;
    }

    public void push(String text){
        list.add(text);
        priorityList.add(0);
    }

    public void push(String text, int priority){
        int index = getAddIndex(priority);

        list.add(index, text);
        priorityList.add(index, priority);
    }

    // 何もpushされてなかった時のエラー処理を含む
    public String pop(){
        try {
            return list.get(startIndex++);
        } catch(IndexOutOfBoundsException e) {
            startIndex--;
            return "（値がありません．）";
        }
    }

    // 優先度を比較して挿入位置を出力する処理
    private int getAddIndex(int priority){

        for(int i=priorityList.size()-1; i>=startIndex; i--){
            if(priorityList.get(i) >= priority){
                return i+1;
            }
        }

        return startIndex;
    }
}