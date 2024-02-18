import java.util.InputMismatchException;
import java.util.Scanner;

public class Example05{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("数値を入力：");

        try{
            // tryには例外が発生する可能性のある処理を記述します
            int inputNumber = scanner.nextInt();
            // エラーが発生した場合ここから下の行は実行されず、catchに飛ぶ
            System.out.printf("入力した数値は%dですね！\n",inputNumber);
            
        }catch(InputMismatchException e){
            // catch部分には例外が発生した場合に実行したい内容を記述します
            System.out.println("例外が発生しました。");
        }

        scanner.close();

        System.out.println("プログラムは終了しました！");

        // 発生している例外の種類が「InputMismatchException」ということが分かりました。
        // ここで例外と適切に処理する方法を確認しましょう。
        // そのために使うのがtry-catch文です。
        // ここで「どの処理をtryに入れるか」がポイントになります。
    }
}