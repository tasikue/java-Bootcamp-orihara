import java.util.ArrayList;
import java.util.List;

public class ListPrinter {
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();

        list.add("Chiwawa");
        list.add("Pomeranian");
        list.add("Bulldog");
        list.add("Akita");
        list.add("Poodle");

        ListPrinter printer = new ListPrinter();

        printer.printAllElements(list);
    }

    public void printAllElements(List<String> list){
        for(String str : list){
            System.out.printf("%d => %s \n", list.indexOf(str), str);
        }
    }
}
