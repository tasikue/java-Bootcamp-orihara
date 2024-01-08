import java.util.ArrayList;
import java.util.List;

public class ListElementPrinter {
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();

        list.add("000");
        list.add("111");
        list.add("222");

        for(String str: list){
            System.out.printf("%d 番目の要素 => %s %n", list.indexOf(str), str);
        }
    }
}
