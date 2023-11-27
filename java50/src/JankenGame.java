import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame
 */
public class JankenGame {

    private static final String[] JANKEN = {"グー", "チョキ", "パー"};

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.println("じゃんけん勝負");
        System.out.println("グーチョキパーを数字で入力してね");
        for(int i=0; i<JANKEN.length; i++){
            System.out.printf("%d: %s \n", i, JANKEN[i]);
        }
        System.out.println();
        System.out.printf("最初はぐー、じゃんけん: ");

        while (true) {
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
                    System.out.println("あなたの勝ち");
                } else {
                    System.out.println("あなたの負け");
                }
                break;
            }
        }
        scan.close();
    }

    private static boolean isWin(int com, int player){

        for(int i=0; i<JANKEN.length; i++){
            for(int j=0; j<JANKEN.length; j++){
                if(com == i && player == j){
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