import java.util.InputMismatchException;
import java.util.Scanner;

public class Example06{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("数値を入力：");

        try{
            int inputNumber = scanner.nextInt();
            System.out.printf("入力した数値は%dですね！\n",inputNumber);
        }catch(InputMismatchException e){
            // catchした例外を表示するとどうなるか？
            // エラー内容だけが出力される
            System.out.println(e);
        }

        scanner.close();

        System.out.println("プログラムは終了しました！");
    }
}