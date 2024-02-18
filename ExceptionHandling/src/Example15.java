public class Example15 {
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

        try{
            System.out.println(numbers[0]);

            System.out.println(numbers[4]);

            System.out.println(numbers[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("method2で例外処理を行いました。");
        }
        System.out.println("method2メソッドは終了しました。");
    }

    // まずはmethod2で例外が発生した時点で対処をする方法です。
}
