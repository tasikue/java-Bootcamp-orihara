import java.util.Random;
import java.util.Scanner;

/**
 * TrumpHitGame
 */
public class TrumpHitGame2 {

    private final String[] TRUMP_FIGURE = {
        "ハート", "ダイヤ", "スペード", "クローバー"
    };
    private final String[] TRUMP_NUMBER = {
        "A", "2", "3", "4", "5", "6", "7", 
        "8", "9", "10", "J", "Q", "K"
    };

    public static void main(String[] args) {
        
        TrumpHitGame2 app = new TrumpHitGame2();
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        int trumpFigIndex = ran.nextInt(app.TRUMP_FIGURE.length);
        int trumpNumIndex = ran.nextInt(app.TRUMP_NUMBER.length);

        // チャレンジ2: 回数制限
        final int FIG_LIMIT = 2;
        final int NUM_LIMIT = 4;

        // カンニング
        System.out.printf("%s %s \n\n", app.TRUMP_FIGURE[trumpFigIndex], app.TRUMP_NUMBER[trumpNumIndex]);

        System.out.println("トランプを選んだよ");
        System.out.println("トランプの図柄を当ててね");

        for(int i=0; i<app.TRUMP_FIGURE.length; i++){
            System.out.printf("%d: %s \n", i, app.TRUMP_FIGURE[i]);
        }

        int figureLimit = 0;
        while(figureLimit != FIG_LIMIT){
            System.out.printf("どれだと思う？: ");
            int figAnswer = scan.nextInt();

            if(trumpFigIndex == figAnswer){
                System.out.printf("正解！図柄は %s だよ\n", app.TRUMP_FIGURE[trumpFigIndex]);
                System.out.println("次は数字を当ててね");
                break;
            } else if(trumpFigIndex != figAnswer){
                System.out.printf("残念！%s じゃないよ\n", app.TRUMP_FIGURE[figAnswer]);
                figureLimit++;
            }
        }

        int numberLimit = 0;
        while(numberLimit != NUM_LIMIT && figureLimit != FIG_LIMIT){
            System.out.printf("どれだと思う？: ");
            String numAnswer = scan.next();
            
            if(app.TRUMP_NUMBER[trumpNumIndex].equals(numAnswer)){
                System.out.printf("正解！ %s の %s だよ\n", app.TRUMP_FIGURE[trumpFigIndex], app.TRUMP_NUMBER[trumpNumIndex]);
                break;
            } else {

                // チャレンジ1: 数字大小のヒント
                int numSize = 0;
                for(int i=0; i<app.TRUMP_NUMBER.length; i++){
                    if(app.TRUMP_NUMBER[i].equals(numAnswer)){
                        numSize = trumpNumIndex - i;
                    }
                }

                System.out.printf("残念！ %s じゃないよ\n", numAnswer);
                numberLimit++;
                if(numSize > 0){
                    System.out.println("もう少し大きいかも");
                } else {
                    System.out.println("もう少し小さいかも");
                }
            }  
        }

        if(numberLimit == NUM_LIMIT || figureLimit == FIG_LIMIT){
            System.out.println("また挑戦してね！");
        }
        scan.close();
    }
}
