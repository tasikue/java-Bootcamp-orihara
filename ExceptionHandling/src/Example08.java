public class Example08{
    public static void main(String[] args) {
        int[] array = null;

        try{
            System.out.println(array[0]);
        } catch (NullPointerException e){
            System.out.println("ポインタがヌルです！");
        }

        System.out.println("プログラムは終了しました。");

        // try-catch文を追加して、
        // 例外が発生した場合は「ポインターがヌルです！」と表示し後に
        // 「プログラムは終了しました。」が表示されるようにしましょう。
    }
}