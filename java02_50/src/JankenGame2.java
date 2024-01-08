import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame2
 * チャレンジ1: 3回勝負の追加
 */
public class JankenGame2 {

    private static final String[] JANKEN = {"グー", "チョキ", "パー"};

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner scan = new Scanner(System.in);


        // チャレンジ1 3回勝負
        final int COUNT = 3;
        boolean[] isWinner = new boolean[COUNT];

        System.out.printf("じゃんけん %d 回勝負\n", COUNT);
        System.out.println("グーチョキパーを数字で入力してね");
        for(int i=0; i<JANKEN.length; i++){
            System.out.printf("%d: %s \n", i, JANKEN[i]);
        }

        System.out.println();
        System.out.printf("最初はぐー、じゃんけん: ");

        int tmpCount=0;
        while (tmpCount < COUNT) {

            // 乱数0~2
            int jankenCOM = ran.nextInt(JANKEN.length);

            int jankenAnswer = scan.nextInt();
            System.out.printf("%s(COM)と%s(Player)で…\n", JANKEN[jankenCOM], JANKEN[jankenAnswer]);

            if(jankenCOM == jankenAnswer){
                System.out.println("あいこだよ！");
                System.out.println();
                System.err.printf("あいこで: ");
            } else {

                boolean isWinCOMorPlayer = isWin(jankenCOM, jankenAnswer);
                if(isWinCOMorPlayer){
                    System.out.println("あなたの勝ち\n");
                    isWinner[tmpCount] = true;
                } else {
                    System.out.println("あなたの負け\n");
                    isWinner[tmpCount] = false;
                }
                tmpCount++;

                if(tmpCount < 3){
                    System.out.printf("%d 戦目！", tmpCount+1);
                    System.out.printf("最初はぐー、じゃんけん: ");
                }
            }
        }
        for(int j=0; j<isWinner.length; j++){
            if(isWinner[j]){
                System.out.printf("%d 回目 あなたの勝ち \n", j+1);
            } else {
                System.out.printf("%d 回目 あなたの負け \n", j+1);
            }
        }
        scan.close();
    }

    private static boolean isWin(int com, int player){

        for(int i=0; i<JANKEN.length; i++){
            for(int j=0; j<JANKEN.length; j++){
                if((com == i) && (player == j)){
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
