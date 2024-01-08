import java.util.Random;
import java.util.Scanner;

/**
 * NumberHitGame
 */
public class NumberHitGame {

    public static void main(String[] args) {
        
        Random random = new Random();
        // ★黄色い線の警告は必ず解消してから提出お願いします。
        Scanner scan = new Scanner(System.in);

        // ★100はマジックナンバーです。定数化しましょう！
        // 　補修性と可読性が上がります。
        // 　また、100に対して作成される乱数は0~99のため、コメントにそれを記述するのが好ましい
        int setAnswer = random.nextInt(100);
        // ★setCountはプログラムで変化する事はないため、定数化をしましょう
        // 　・定数化する場合は命名規則も違いますのでご注意ください
        // 　・また、他の言語と同じように定数は他のプログラムより先に各ことで、
        //　　　値の変更（修正）が必要な場合にプログラム内を探さなくてもプログラムの先頭で見つかります。
        int setCount = 5;

        // デバックカンニング用
        //System.out.printf("%d \n\n", setAnswer);

        System.out.printf("数字を当ててみてね。\n\n");
        System.out.printf("答えられるのは %d 回までだよ。\n\n", setCount);

        for (int i=1; i<=setCount; i++) {

            System.out.printf("%d 回目: ", i);
            // ★変数の命名は「神様視点」が好ましいので、inputAnswerなどが良いです
            int yourAnswer = scan.nextInt();

            // ★省略できる条件があります
            if(setAnswer == yourAnswer){
                System.out.printf("すごい！！ %d 回で当てられちゃった！", i);
                break;
            } else if(setAnswer < yourAnswer){
                System.out.printf("もっと小さい数字だよ\n\n");
            } else if(setAnswer > yourAnswer){
                System.out.printf("もっと大きい数字だよ\n\n");
            }

            if(setCount == i){
                System.out.printf("残念！！　正解は %d でした！", setAnswer);
            }
        }
        scan.close();
    }
}