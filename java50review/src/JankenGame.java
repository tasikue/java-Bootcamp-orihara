import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame
 */
public class JankenGame {

    public static void main(String[] args) {

        Random ran = new Random();
        // ★警告を解消
        Scanner scan = new Scanner(System.in);

        // ★定数化
        // 　再提出の課題を軽く覗きました。39番と同じような書き方で大丈夫です。
        // 　44番のようにフィールドにする場合は、staticを付ける事でインスタンス化しなくて済みます
        String[] janken = {"グー", "チョキ", "パー"};
        // ★マジックナンバーを解消
        // ★コンピュータの手を文字列として保持する事が余分なプログラムを書く事に繋がっていますので
        // 　数値で良いのではないでしょうか？
        String jankenCOM = janken[ran.nextInt(3)];
        
        // ★消す
        // カンニング
        System.out.println(jankenCOM);

        System.out.println("じゃんけん勝負");
        System.out.println("グーチョキパーを数字で入力してね");
        for(int i=0; i<janken.length; i++){
            System.out.printf("%d: %s \n", i, janken[i]);
        }
        System.out.println();
        System.out.printf("最初はぐー、じゃんけん: ");

        while (true) {
            int jankenAnswer = scan.nextInt();
            System.out.printf("%s(COM)と%s(Player)で…\n", jankenCOM, janken[jankenAnswer]);

            if(jankenCOM.equals(janken[jankenAnswer])){
                System.out.println("あいこだよ！");
                System.out.println();
                System.err.printf("あいこで: ");
            } else {
                // ★「is」だけでは変数の意味が分からないです
                // 　「java boolean変数　命名」で調べると名前の付け方の例がたくさんあります
                boolean is = isWin(janken, jankenCOM, janken[jankenAnswer]);
                if(is){
                    System.out.println("あなたの勝ち");
                } else {
                    System.out.println("あなたの負け");
                }
                break;
            }
        }
        
    }

    // ★jankenはstaticフィールドにすると引数としてもらう必要がなくなります
    private static boolean isWin(String[] janken, String com, String player){

        for(int i=0; i<janken.length; i++){
            for(int j=0; j<janken.length; j++){
                if(com.equals(janken[i]) && player.equals(janken[j])){
                    if((i - j) == 1 || (i - j) == -2){
                        // 勝ち
                        return true;
                    } else {
                        // 負け or あいこ
                        return false;
                    }
                }
            }
        }
        return false;
    }
}