public class Example16 {
    public static void main(String[] args){
        method1();
        System.out.println("mainメソッドは終了しました。");
    }

    public static void method1(){
        try{
            method2();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("method1で例外処理を行いました。");
        }
        System.out.println("method1メソッドは終了しました。");
    }

    // 今度はmethod1で例外を対処しました。
    // ここでmethod2の処理は最後まっで実行されなかったことに注目したいです。

    public static void method2(){
        int[] numbers = {5,10,15,20,25};

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

        System.out.println(numbers[5]);
        
        System.out.println("method2メソッドは終了しました。");
    }
}
