import java.util.Random;
import java.util.Scanner;

/**
 * TrampHitGame
 */
public class TrampHitGame {

    public static void main(String[] args) {
        
        Random ran = new Random();
        // ★警告の解消
        Scanner scan = new Scanner(System.in);

        // ★tramp → trumpの綴りミスかと思います
        // ★「4」と「13」はマジックナンバーですが、この場合は定数化ではなく
        // 　「なにか」の値を使ってほしいです。なぜ4と13なのかを考えると分かりやすいです。
        int trampFigIndex = ran.nextInt(4);
        int trampNumIndex = ran.nextInt(13);

        // ★値が変わらないため、定数化しましょう
        String[] trampFig = {"ハート", "ダイヤ", "スペード", "クローバー"};
        String[] trampNum = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // ★数当てゲームも残っていましたが、提出時はデバッグコードを消しましょう
        // カンニング
        System.out.printf("%s %s \n\n", trampFig[trampFigIndex], trampNum[trampNumIndex]);

        System.out.println("トランプを選んだよ");
        System.out.println("トランプの図柄を当ててね");

        for(int i=0; i<trampFig.length; i++){
            System.out.printf("%d: %s \n", i, trampFig[i]);
        }

        while(true){
            System.out.printf("どれだと思う？: ");
            int figAnswer = scan.nextInt();

            if(trampFigIndex == figAnswer){
                System.out.printf("正解！図柄は %s だよ\n", trampFig[trampFigIndex]);
                break;
            // ★このチェックは必要でしょうか？
            } else if(trampFigIndex != figAnswer){
                // ★入力値が0～3以外だった場合はどうなりますか？（応用）
                System.out.printf("残念！%s じゃないよ\n", trampFig[figAnswer]);
            }
        }

        System.out.println("次は数字を当ててね");

        while(true){
            System.out.printf("どれだと思う？: ");
            String numAnswer = scan.next();
            
            if(trampNum[trampNumIndex].equals(numAnswer)){
                System.out.printf("正解！ %s の %s だよ\n", trampFig[trampFigIndex], trampNum[trampNumIndex]);
                break;
            } else {
                System.out.printf("残念！ %s じゃないよ\n", numAnswer);
            }  
        }
    }
}