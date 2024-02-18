import java.util.InputMismatchException;
import java.util.Scanner;

public class Example10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
        System.out.print("1つ目の数値を入力：");
        int firstNumber = scanner.nextInt();

        System.out.print("2つ目の数値を入力：");
        int secondNumber = scanner.nextInt();

        int divisionResult = firstNumber / secondNumber;

        System.out.printf("%d / %d = %d",firstNumber, secondNumber, divisionResult);
        } catch(InputMismatchException e){
            System.out.println("整数以外入力することはできません");
        }catch (ArithmeticException e){
            System.out.println("ゼロ除算はできません");
        }

        scanner.close();

        System.out.println("プログラムは終了しました！");

        // 07と同じプログラムですが今度は文字列を入力した場合のことも考えましょう
        //   発生する可能性のある例外は２種類です
        //   このような場合はそれぞれの例外に対して処理を行うこともできれば
        //　　まとめて一つの対処にすることもできます
        //　　まずは別々に処理しましょう
        //　　(1)入力時の例外が発生したら「整数以外を入力することはできません」と表示して
        //　　　　「プログラムは終了しました！」と表示する
        //　　(2)２つ目の数値として「0」を入力した場合は「ゼロ除算はできません」と表示して
        //　　　　「プログラムは終了しました！」と表示する
    }
}