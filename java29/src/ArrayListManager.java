import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListManager
 */
public class ArrayListManager {

    public static void main(String[] args) {
        

        // 01
        List<String> list = new ArrayList<>();

        // 02
        Boolean isListEmpty = list.isEmpty();
        System.out.printf("list の要素が空かどうか => %b %n", isListEmpty);

        // 03
        list.add("000");
        list.add("111");
        list.add("222");

        // 04
        int listSize = list.size();
        System.out.printf("list の要素数 => %d %n",  listSize);

        // 05
        String Keyword = "111";
        Boolean hasKeyword = list.contains(Keyword);
        System.out.printf("list の要素に 111 があるかどうか => %b %n", hasKeyword);

        // 06
        int targetIndex = 2;
        String target = list.get(targetIndex);
        System.out.printf("list の %d 番目にある要素 => %s %n", targetIndex, target);

        // 07
        target = "000";
        targetIndex = list.indexOf(target);
        System.out.printf("listの要素「%s」があるのは => %d 番目 %n%n", target, targetIndex);
    
        // 08
        list.set(2, "UPDATE");
        list.remove(0);

        // 09
        System.out.printf("list の 0 番目の要素 => %s %n", list.get(0));
        System.out.printf("list の 1 番目の要素 => %s %n", list.get(1));
    }
}