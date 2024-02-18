public class Example03 {
    public static void main(String[] args){
        method1();

        System.out.println("プログラムが終了しました！");

        // スタックトレース情報を見ると先ほどとは少し違う表示になっています。
        // スタックトレースは下から読んでいくと分かりやすいです。
        // メインメソッドからどのメソッドがどの順番で呼ばれたかを確認できます。
        
        // この場合は
        //   mainメソッド → method1メソッド → method2メソッド
        // の順に呼び出した後に、method2で例外が発生しましたのが分かります。
    }

    public static void method1(){
        method2();
    }

    public static void method2(){
        int[] numbers = {5,10,15,20,25};

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

        System.out.println(numbers[5]);
    }
}
