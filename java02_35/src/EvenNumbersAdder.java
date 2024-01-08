/**
 * EvenNumbersAdder
 */
public class EvenNumbersAdder {

    public static void main(String[] args) {
        
        int sum = 0;
        int count = 1;

        while(true){
            if((count % 2) == 0){
                sum = sum + count;
                System.out.printf("i= %d %n", count);
            }
            if(count == 10) break;
            count++;
        }
        System.out.println();
        System.out.printf("sum= %d %n", sum);
    }

    // 解答例では奇数の時ループの最初に戻ってた
}