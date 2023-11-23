import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame
 */
public class JankenGame {

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        String[] janken = {"グー", "チョキ", "パー"};

        String jankenCOM = janken[ran.nextInt(3)];
        
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