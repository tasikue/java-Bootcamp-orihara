import java.util.Scanner;

public class Example09{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("1つ目の数値を入力：");
        int firstNumber = scanner.nextInt();

        System.out.print("2つ目の数値を入力：");
        int secondNumber = scanner.nextInt();

        try{
        int divisionResult = firstNumber / secondNumber;
        System.out.printf("%d / %d = %d \n",firstNumber, secondNumber, divisionResult);
        } catch (ArithmeticException e){
            System.out.println("ゼロ除算はできません。");
        }

        scanner.close();

        System.out.println("プログラムは終了しました！");

        // 2つ目の数値として「0」を入力するとどうなるか？
        // 2つ名の数値として「0」を入力した場合は割り算結果の出力の代わりに
        //  「ゼロ除算はできません。」と表示するようにプログラムを修正してください。
        //   文字を入力した場合の例外は一旦考えないでください
    }
}