import java.util.InputMismatchException;
import java.util.Scanner;

public class Example07{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("数値を入力：");

        try{
            int inputNumber = scanner.nextInt();
            System.out.printf("入力した数値は%dですね！\n",inputNumber);
        }catch(InputMismatchException e){
            // catchした例外のスタックトレースを表示する
            // 処理を続ける
            e.printStackTrace();
        }

        scanner.close();

        System.out.println("プログラムは終了しました！");
    }
}