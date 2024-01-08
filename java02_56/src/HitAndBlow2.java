import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/**
 * HitAndBlow2
 * チャレンジ1: 5つの数字
 * チャレンジ2
 */
public class HitAndBlow2 {

    // チャレンジ1: 5つの数字
    static final int DIGIT = 5;
    static final int TEN_NUMBER = 10;

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] comNumber = getRandomNumber();


        int hit=0; 
        int blow=0;
        int count=0;
        int hintCount = 0;
        while(hit != DIGIT){

            System.out.printf("5桁の数字を入力してください。");
            int inputAnswer = scan.nextInt();   
            int[] inputNumber = getInputArrayNumber(inputAnswer);

            hit = hasHit(inputNumber, comNumber);
            blow = hasBlow(inputNumber, comNumber);
            System.out.printf("ヒット: %d個、ブロー: %d個\n", hit, blow);
            count++;

            // チャレンジ2: 3回ごとにヒントを出す
            if((count % 3) == 0){
                System.out.printf("ヒント！: ");
                for(int i=0; i<DIGIT; i++){
                    if(i <= hintCount){
                        System.out.printf("%d ", comNumber[i]);
                    } else {
                        System.out.printf("? ");
                    }
                }
                System.out.println();
                hintCount++;
            }
        }

        System.out.printf("おめでとう！%d回目で成功♪\n", count);
        scan.close();
    }

    
    private static int[] getRandomNumber(){
        Random ran = new Random();
        int[] comNumber = new int[DIGIT];

        for(int i=0; i<DIGIT; i++){
            int tmpComNumber = ran.nextInt(TEN_NUMBER);
            boolean isSameNumber = false;

            for(int j=0; j<i; j++){
                if(tmpComNumber == comNumber[j]){
                    isSameNumber  = true;
                }
            }

            if(isSameNumber){
                i--;
            } else {
                comNumber[i] = tmpComNumber;
            }
        }

         return comNumber;
    }


    private static int[] getInputArrayNumber(int inputNumber){
        int[] inputArrayNumber = new int[DIGIT];
        final int TEN = 10;

        int calc=0;
        for(int i=0; i<DIGIT; i++){
            if(i == 0){
                calc = 0;
            } else {
                calc = calc + inputArrayNumber[i-1]*(int)Math.pow(TEN, DIGIT-i);
            }
            inputArrayNumber[i] = (inputNumber - calc) / (int)Math.pow(TEN, (DIGIT-1)-i);
        }

        return inputArrayNumber;
    }

    private static int hasHit(int[] input, int[] com){
        int countHit = 0;

        for(int i=0; i<input.length; i++ ){
            if(input[i] == com[i]){
                countHit++;
            }
        }

        return countHit;
    }

    private static int hasBlow(int[] input, int[] com){
        int countBlow = 0;

        for(int i=0; i<input.length; i++ ){
            for(int j=0; j<com.length; j++){
                if(input[i] == com[j]){
                    countBlow++;
                }
            }
        }

        return countBlow;
    }
}