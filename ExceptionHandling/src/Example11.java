import java.util.Scanner;

public class Example11{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
        System.out.print("1つ目の数値を入力：");
        int firstNumber = scanner.nextInt();

        System.out.print("2つ目の数値を入力：");
        int secondNumber = scanner.nextInt();

        int divisionResult = firstNumber / secondNumber;

        System.out.printf("%d / %d = %d",firstNumber, secondNumber, divisionResult);
        } catch(Exception e){
            System.out.println("不正な入力です");
        }
        scanner.close();

        System.out.println("プログラムは終了しました！");

        // 08と同じように発生する可能性のある例外は２種類です
        //   このような場合はそれぞれの例外に対して処理を行うこともできれば
        //　　まとめて一つの対処にすることもできます
        //　　今度はまとめて処理しましょう
        //　　入力の例外または0除算の場合は「不正な入力です」と表示して
        //　　　　「プログラムは終了しました！」と表示する
        //　　　　※catchは１つしか使っては行けません

        // Javaクラスの階層ツリー
        // https://docs.oracle.com/javame/config/cdc/ref-impl/cdc1.1.2/jsr218/ja/java/lang/package-tree.html
    }
}