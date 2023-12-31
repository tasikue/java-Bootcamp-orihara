import java.util.Random;
import java.util.Scanner;

/**
 * NumberHitGame
 */
public class NumberHitGame2 {

    public static void main(String[] args) {
        
        Random random = new Random();
        // NumberHitGameと同じ
        Scanner scan = new Scanner(System.in);
        // NumberHitGameと同じ
        int setAnswer = random.nextInt(1000);
        // NumberHitGameと同じ
        int setCount = 10;

        // デバックカンニング用
        System.out.printf("%d \n\n", setAnswer);

        System.out.printf("数字を当ててみてね。\n\n");
        System.out.printf("答えられるのは %d 回までだよ。\n\n", setCount);

        for (int i=1; i<=setCount; i++) {

            System.out.printf("%d 回目: ", i);
            int yourAnswer = scan.nextInt();

            int distance = setAnswer - yourAnswer;
            // if(distance == 0){
            //     System.out.printf("すごい！！ %d 回で当てられちゃった！", i);
            //     break;
            // } else if(-10 <= distance && distance < 0){
            //     System.out.printf("もう少し小さい数字だよ\n\n");
            // } else if(-100 <= distance && distance < -10){
            //     System.out.printf("もっと小さい数字だよ\n\n");
            // } else if(distance < -100){
            //     System.out.printf("かなり小さい数字だよ\n\n");
            // } else if(distance > 0 && distance <= 10){
            //     System.out.printf("もう少し大きい数字だよ\n\n");
            // } else if(distance > 10 && distance <= 100){
            //     System.out.printf("もっと大きい数字だよ\n\n");
            // } else if(distance > 100){
            //     System.out.printf("かなり大きい数字だよ\n\n");
            // }

            // ★if文の中の条件が増えすぎると可読性が下がり、バグが発生しやすく
            // 　デバッグもしにくいため、できるだけ読みやすくすることを心がけましょう
            if(distance == 0){
                System.out.printf("すごい！！ %d 回で当てられちゃった！", i);
                break;
            }else if(distance < 0){ // distanceがマイナスの場合
                // ★NumberHitGameと同じように「-10」などは定数化すると良い
                if(distance >= -10){
                    System.out.printf("もう少し小さい数字だよ\n\n");
                }else if(distance >= -100){
                    System.out.printf("もっと小さい数字だよ\n\n");
                }else{
                    System.out.printf("かなり小さい数字だよ\n\n");
                }
            }else{ // distanceがプラスの場合
                if(distance <= 10){
                    System.out.printf("もう少し大きい数字だよ\n\n");
                }else if(distance <= 100){
                    System.out.printf("もっと大きい数字だよ\n\n");
                }else{
                    System.out.printf("かなり大きい数字だよ\n\n");
                }
            }

            if(setCount == i){
                System.out.printf("残念！！　正解は %d でした！", setAnswer);
            }
        }
    }
}
