import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * UntilTargetNumberLooper
 */
public class UntilTargetNumberLooper {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        final int NUM = 77;
        int point = 0;

        System.out.printf("%d が入力されたら終了します. %n", NUM);

        int count = 1;
        while(NUM != point){
            System.out.printf("%d 回目: 数字を入力してください: ", count);
            String tmpPoint = scan.next();
            try{
                point = Integer.parseInt(tmpPoint);
            } catch (NumberFormatException e){
                System.out.printf("  => 数値以外の値 ( %s ) が入力されました. %n%n", tmpPoint);
            }
            count++;
        }
        System.out.println();
        System.out.printf("  => %d が入力されたので終了しました. %n", point);
        scan.close();
    }
}