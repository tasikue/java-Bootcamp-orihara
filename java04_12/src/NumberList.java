import java.util.ArrayList;
import java.util.List;

/**
 * NumberList
 */
public class NumberList {

    public static void main(String[] args) {
        
        final int MIN = 3;
        final int MAX = 11;
        List<Integer> numbers = new ArrayList<>();

        for(int i=MIN; i<=MAX; i++){
            numbers.add(i);
        }

        for(int num : numbers){ 
            System.out.printf("[%d] %d\n", numbers.indexOf(num), num);
        }
    }
}