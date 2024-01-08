/**
 * TestResultNotifier
 */
import java.util.Scanner;

 public class TestResultNotifier {

    public static void main(String[] args) {

        System.out.println("100点満点中、何点だったか回答してください.");
        
        System.out.printf("数学のテストの点数は？：");
        Scanner scan =new Scanner(System.in);
        int point = scan.nextInt();

        String testResult = point >= 70 ? "合格" : "不合格";

        System.out.printf("数学のテストは %s です.", testResult);
    }
}