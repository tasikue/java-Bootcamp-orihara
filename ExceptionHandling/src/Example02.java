public class Example02 {
    public static void main(String[] args){
        method1();

        System.out.println("プログラムが終了しました！");

        // スタックトレース情報を見ると先ほどとは少し違う表示になっています。
        // スタックトレースは下から読んでいくと分かりやすいです。
    }

    public static void method1(){
        int[] numbers = {5,10,15,20,25};

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

        System.out.println(numbers[5]);
    }
}
