import java.util.Scanner;

public class UntilBlankLooper {
    public static void main(String[] args) {
        
        Scanner stdin = new Scanner(System.in);
        final String BLANK = "";

        String inputtedString;
        int count = 0;

        System.out.println(
            "文字が入力されず Enter キーが押されたら終了します. \n"
        );

        /* 処理 */

        do{
            System.out.printf("%d 回目: 文字を入力してください. ", ++count);
            inputtedString = stdin.nextLine();

        }while( !inputtedString.equals(BLANK));

        System.out.println("\n => 文字が入力されなかったので終了しました.");
        stdin.close();
    }
}
