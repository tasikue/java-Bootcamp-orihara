import java.util.Random;
import java.util.Scanner;

/**
 * JankenGame3
 * チャレンジ2: あっち向いてほいの追加
 */
public class JankenGame3 {

    public static void main(String[] args) {

        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        String[] janken = {"グー", "チョキ", "パー"};

        // チャレンジ1 3回勝負
        int COUNT = 3;
        boolean[] isWinner = new boolean[COUNT];

        System.out.printf("あっちむいてほい %d 回勝負\n", COUNT);
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
                boolean is = isWin(janken, jankenCOM, janken[jankenAnswer]);
                if(is){
                    System.out.println("あなたの勝ち\n");
                    
                    // チャレンジ2: あちほい
                    boolean isHoi = achiHoi();
                    if(isHoi){
                        isWinner[tmpCount] = true;
                        tmpCount++;
                        System.out.println("あなたの勝ち\n");
                    }
                } else {
                    System.out.println("あなたの負け\n");

                    // チャレンジ2: あちほい
                    boolean isHoi = achiHoi();
                    if(isHoi){
                        isWinner[tmpCount] = false;
                        tmpCount++;
                        System.out.println("あなたの負け\n");
                    }
                }
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

    private static boolean achiHoi(){

        Scanner scan = new Scanner(System.in);
        Random ran = new Random();

        // ↑: 0, ↓: 1, →: 2, ←: 3
        String[] hoi = {"↑", "↓", "→", "←"};
        int arrCOMIndex = ran.nextInt(4);

        for(int i=0; i<hoi.length; i++){
            System.out.printf("%d: %s \n", i, hoi[i]);
        }
        System.out.printf("あっちむいて: ");
        int arrAnswer = scan.nextInt();

        if(arrCOMIndex == arrAnswer){
            return true;
        } else {
            System.out.println("もう一度！\n");
            return false;
        }
    }
}
