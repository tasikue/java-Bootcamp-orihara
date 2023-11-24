import java.util.Random;
import java.util.Scanner;

/**
 * NumberHitGame
 */
public class NumberHitGame2 {

    public static void main(String[] args) {

        final int RANDOM_RARGE = 1000;
        final int SET_COUNT = 5;
        
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // 0~999
        int setAnswer = random.nextInt(RANDOM_RARGE);

        // デバックカンニング用
        //System.out.printf("%d \n\n", setAnswer);

        System.out.printf("数字を当ててみてね。\n\n");
        System.out.printf("答えられるのは %d 回までだよ。\n\n", SET_COUNT);

        for (int i=1; i<=SET_COUNT; i++) {

            System.out.printf("%d 回目: ", i);
            int inputAnswer = scan.nextInt();

            /* 定数設定 */
            final int DISTANCE_PLUS_LITTLE = 10;
            final int DISTANCE_PLUS_MANY = 100;
            final int DISTANCE_MINUS_LITTLE = -10;
            final int DISTANCE_MINUS_MANY = -100;

            int distance = setAnswer - inputAnswer;
            if(distance == 0){
                System.out.printf("すごい！！ %d 回で当てられちゃった！", i);
                break;
            } else if(distance < 0){
                if(distance >= DISTANCE_MINUS_LITTLE){
                    System.out.printf("もう少し小さい数字だよ\n\n");
                }else if(distance >= DISTANCE_MINUS_MANY){
                    System.out.printf("もっと小さい数字だよ\n\n");
                }else{
                    System.out.printf("かなり小さい数字だよ\n\n");
                }
            } else {
                if(distance <= DISTANCE_PLUS_LITTLE){
                    System.out.printf("もう少し大きい数字だよ\n\n");
                }else if(distance <= DISTANCE_PLUS_MANY){
                    System.out.printf("もっと大きい数字だよ\n\n");
                }else{
                    System.out.printf("かなり大きい数字だよ\n\n");
                }
            }

            if(SET_COUNT == i){
                System.out.printf("残念！！　正解は %d でした！", setAnswer);
            }
        }
        scan.close();
    }
}
