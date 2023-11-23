import java.util.Random;
import java.util.Scanner;

/**
 * TrampHitGame
 */
public class TrampHitGame2 {

    public static void main(String[] args) {
        
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        int trampFigIndex = ran.nextInt(4);
        int trampNumIndex = ran.nextInt(13);

        String[] trampFig = {"ハート", "ダイヤ", "スペード", "クローバー"};
        String[] trampNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // チャレンジ2: 回数制限
        int FIG_LIMIT = 2;
        int NUM_LIMIT = 4;

        // カンニング
        System.out.printf("%s %s \n\n", trampFig[trampFigIndex], trampNum[trampNumIndex]);

        System.out.println("トランプを選んだよ");
        System.out.println("トランプの図柄を当ててね");

        for(int i=0; i<trampFig.length; i++){
            System.out.printf("%d: %s \n", i, trampFig[i]);
        }

        int fLim = 0;
        while(fLim != FIG_LIMIT){
            System.out.printf("どれだと思う？: ");
            int figAnswer = scan.nextInt();

            if(trampFigIndex == figAnswer){
                System.out.printf("正解！図柄は %s だよ\n", trampFig[trampFigIndex]);
                System.out.println("次は数字を当ててね");
                break;
            } else if(trampFigIndex != figAnswer){
                System.out.printf("残念！%s じゃないよ\n", trampFig[figAnswer]);
                fLim++;
            }
        }

        int nLim = 0;
        while(nLim != NUM_LIMIT && fLim != FIG_LIMIT){
            System.out.printf("どれだと思う？: ");
            String numAnswer = scan.next();
            
            if(trampNum[trampNumIndex].equals(numAnswer)){
                System.out.printf("正解！ %s の %s だよ\n", trampFig[trampFigIndex], trampNum[trampNumIndex]);
                break;
            } else {

                // チャレンジ1: 数字大小のヒント
                int numSize = 0;
                for(int n=0; n<trampNum.length; n++){
                    if(trampNum[n].equals(numAnswer)){
                        numSize = trampNumIndex - n;
                    }
                }

                System.out.printf("残念！ %s じゃないよ\n", numAnswer);
                nLim++;
                if(numSize > 0){
                    System.out.println("もう少し大きいかも");
                } else {
                        System.out.println("もう少し小さいかも");
                }
            }  
        }

        if(nLim == NUM_LIMIT || fLim == FIG_LIMIT){
            System.out.println("また挑戦してね！");
        }
    }
}
