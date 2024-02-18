public class Example17 {
    public static void main(String[] args){
        try{
            method1();
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("mainメソッドで例外処理を行いました。");
        }
        System.out.println("mainメソッドは終了しました。");
    }

    // 今度はmainメソッドで例外を対処しました。
    // ここでmethod1とmethod2の処理は最後まっで実行されなかったことに注目したいです。

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
}
