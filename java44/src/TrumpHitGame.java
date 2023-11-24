import java.util.Random;
import java.util.Scanner;

/**
 * TrumpHitGame
 */
public class TrumpHitGame {

    private final String[] TRUMP_FIGURE = {
        "ハート", "ダイヤ", "スペード", "クローバー"
    };
    private final String[] TRUMP_NUMBER = {
        "A", "2", "3", "4", "5", "6", "7", 
        "8", "9", "10", "J", "Q", "K"
    };

    public static void main(String[] args) {
        
        TrumpHitGame app = new TrumpHitGame();
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        int trumpFigIndex = ran.nextInt(app.TRUMP_FIGURE.length);
        int trumpNumIndex = ran.nextInt(app.TRUMP_NUMBER.length);

        // カンニング
        System.out.printf("%s %s \n\n", app.TRUMP_FIGURE[trumpFigIndex], app.TRUMP_NUMBER[trumpNumIndex]);

        System.out.println("トランプを選んだよ");
        System.out.println("トランプの図柄を当ててね");

        for(int i=0; i<app.TRUMP_FIGURE.length; i++){
            System.out.printf("%d: %s \n", i, app.TRUMP_FIGURE[i]);
        }

        while(true){
            System.out.printf("どれだと思う？: ");
            // 入力は0～3のみ想定
            int figAnswer = scan.nextInt();

            if(trumpFigIndex == figAnswer){
                System.out.printf("正解！図柄は %s だよ\n", app.TRUMP_FIGURE[trumpFigIndex]);
                break;
            } else {
                System.out.printf("残念！%s じゃないよ\n", app.TRUMP_FIGURE[figAnswer]);
            }
        }

        System.out.println("次は数字を当ててね");

        while(true){
            System.out.printf("どれだと思う？: ");
            // 入力は文字のみ想定
            String numAnswer = scan.next();
            
            if(app.TRUMP_NUMBER[trumpNumIndex].equals(numAnswer)){
                System.out.printf("正解！ %s の %s だよ\n", app.TRUMP_FIGURE[trumpFigIndex], app.TRUMP_NUMBER[trumpNumIndex]);
                break;
            } else {
                System.out.printf("残念！ %s じゃないよ\n", numAnswer);
            }  
        }
        scan.close();
    }
}