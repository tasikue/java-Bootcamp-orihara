import java.util.ArrayList;
import java.util.List;

public class ListPrinterSample {
    public static void main(String[] args) {

        List<String> dogs = new ArrayList<>();
        dogs.add("Chiwawa");
        dogs.add("Pomeranian");
        dogs.add("Bulldog");
        dogs.add("Akita");
        dogs.add("Poodle");

        ListPrinterSample printer = new ListPrinterSample<>();
        printer.printAllElements(dogs);
    }

    public void printAllElements(List list) {
        for ( element : list) {
            System.out.printf(
                "%d => %s %n"
                ,list.indexOf(element), element.toString()
            );
        }
    }
}