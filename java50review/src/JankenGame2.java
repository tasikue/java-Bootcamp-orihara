import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame2
 * チャレンジ1: 3回勝負の追加
 */
public class JankenGame2 {

    public static void main(String[] args) {

        Random ran = new Random();
        // ★JankenGameと同じ
        Scanner scan = new Scanner(System.in);
        // ★JankenGameと同じ
        String[] janken = {"グー", "チョキ", "パー"};

        // チャレンジ1 3回勝負
        // ★定数化
        int COUNT = 3;
        boolean[] isWinner = new boolean[COUNT];

        System.out.printf("じゃんけん %d 回勝負\n", COUNT);
        System.out.println("グーチョキパーを数字で入力してね");
        for(int i=0; i<janken.length; i++){
            System.out.printf("%d: %s \n", i, janken[i]);
        }

        System.out.println();
        System.out.printf("最初はぐー、じゃんけん: ");

        int tmpCount=0;
        while (tmpCount < COUNT) {
            String jankenCOM = janken[ran.nextInt(3)];
            // カンニング
            // System.out.printf("今回の答え: %s \n", jankenCOM);

            int jankenAnswer = scan.nextInt();
            System.out.printf("%s(COM)と%s(Player)で…\n", jankenCOM, janken[jankenAnswer]);

            if(jankenCOM.equals(janken[jankenAnswer])){
                System.out.println("あいこだよ！");
                System.out.println();
                System.err.printf("あいこで: ");
            } else {
                // ★JankenGameと同じ
                boolean is = isWin(janken, jankenCOM, janken[jankenAnswer]);
                if(is){
                    System.out.println("あなたの勝ち\n");
                    isWinner[tmpCount] = true;
                } else {
                    System.out.println("あなたの負け\n");
                    isWinner[tmpCount] = false;
                }
                tmpCount++;
                // ★ループを強制的に終了させて、「〇戦目！最初は・・・」と表示しないために
                // 　breakを使っていますが、while文の条件式が無駄になってしまいます。
                // 　ループの終了はwhile文の条件に任せて、ここでは「〇戦目！最初は・・・」を
                // 　表示するかどうかを判定すれば良いのではないでしょうか？
                if(tmpCount == 3) break;

                System.out.printf("%d 戦目！", tmpCount+1);
                System.out.printf("最初はぐー、じゃんけん: ");
            }
        }
        for(int j=0; j<isWinner.length; j++){
            if(isWinner[j]){
                System.out.printf("%d 回目 あなたの勝ち \n", j+1);
            } else {
                System.out.printf("%d 回目 あなたの負け \n", j+1);
            }
        }
    }

    private static boolean isWin(String[] janken, String com, String player){

        for(int i=0; i<janken.length; i++){
            for(int j=0; j<janken.length; j++){
                if(com.equals(janken[i]) && player.equals(janken[j])){
                    if((i - j) == 1 || (i - j) == -2){
                        // 勝ち
                        return true;
                    } else {
                        // 負け (あいこの場合は想定してない)
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
