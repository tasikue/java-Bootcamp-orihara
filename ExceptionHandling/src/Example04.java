import java.util.Scanner;

public class Example04{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("数値を入力：");
        int inputNumber = scanner.nextInt();

        System.out.printf("入力した数値は%dですね！\n",inputNumber);

        scanner.close();

        System.out.println("プログラムは終了しました！");

        // エラーメッセージの見方が分かったので次のことを確認しましょう。
        // (1)入力時に文字列を入力するとどうなるのか？ エラーが出る
        // (2)例外はどの行で発生していますか？　8行目
        // (3)どんな種類の例外が発生しているのか？　入力の型違いエラー
        // (4)例外が発生すると残りのプログラムはどうなりますか？　止まって実行されない
    }
}