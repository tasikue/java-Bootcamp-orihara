/**
 * NumberAdder
 */
public class NumberAdder {

    public static void main(String[] args) {
        
        int orange = 25;
        int apple = 15; 

        System.out.printf("みかん: %d 個\n", orange);
        System.out.printf("りんご: %d 個\n", apple);

        NumberAdder add = new NumberAdder();
        int result = add.addNumber(orange, apple);
        System.out.printf("合計: %d 個\n", result);
    }

    public int addNumber(int x, int y){
        return x + y;
    }
}