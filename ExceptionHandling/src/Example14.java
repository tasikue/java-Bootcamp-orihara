public class Example14 {
    public static void main(String[] args){
        method1();
        System.out.println("mainメソッドは終了しました。");
    }

    public static void method1(){
        method2();
        System.out.println("method1メソッドは終了しました。");
    }

    public static void method2(){
        int[] numbers = {5,10,15,20,25};

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

        System.out.println(numbers[5]);
        System.out.println("method2メソッドは終了しました。");
    }

    // 複数のメソッドを使ってプログラムを作成する場合は、
    // 例外をどこで処理するかも選ぶことができます。
    // まずこの例の実行結果から分かるように例外の発生によって、
    // すべてのメソッドが正常に終了しませんでした。
}
