import java.util.Random;
import java.util.Scanner;

/**
 * NumberHitGame
 */
public class NumberHitGame {

    public static void main(String[] args) {

        final int RANDOM_RARGE = 100;
        final int SET_COUNT = 5;
        
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // 0~99
        int setAnswer = random.nextInt(RANDOM_RARGE);

        System.out.printf("数字を当ててみてね。\n\n");
        System.out.printf("答えられるのは %d 回までだよ。\n\n", SET_COUNT);

        for (int i=1; i<=SET_COUNT; i++) {

            System.out.printf("%d 回目: ", i);
            int inputAnswer = scan.nextInt();


            if(setAnswer < inputAnswer){
                System.out.printf("もっと小さい数字だよ\n\n");
            } else if(setAnswer > inputAnswer){
                System.out.printf("もっと大きい数字だよ\n\n");
            } else {
                System.out.printf("すごい！！ %d 回で当てられちゃった！", i);
                break;
            }

            if(SET_COUNT == i){
                System.out.printf("残念！！　正解は %d でした！", setAnswer);
            }
        }
        scan.close();
    }
}