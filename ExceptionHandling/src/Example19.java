import java.util.Scanner;

public class Example19{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isValidInput = false;

        int inputNumber = 0;

        while(!isValidInput){
            System.out.print("数値を入力：");
            if(scanner.hasNextInt()){
                inputNumber = scanner.nextInt();
                isValidInput = true;
            }else{
                System.out.println("数値は整数で入力をしてください！");
                //nextIntメソッド使用時に回収できていない改行コードを回収
                scanner.nextLine();
            }
        }
        System.out.printf("入力した数値は%dですね！\n",inputNumber);

        scanner.close();

        System.out.println("プログラムは終了しました！");

        // int型の入力方法②
        // 例外を発生させないで入力する
    }
}