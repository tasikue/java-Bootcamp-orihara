public class Example01 {
    public static void main(String[] args){
        int[] numbers = {5,10,15,20,25};

        System.out.println(numbers[0]);

        System.out.println(numbers[4]);

        System.out.println(numbers[5]);

        System.out.println("プログラムが終了しました！");

        // 例外の見方を確認しましょう。
        // 9行目のコメントを解除すると例外が発生します。
        // エラーメッセージの見方
        // 　エラーメッセージは「エラー情報」と「スタックトレース情報」に分かれています。
        // 　「エラー情報」は具体的なエラーの原因が表示されます。
        // 　「スタックトレース情報」はエラーの発生場所が表示されます。
        // https://ittoybox.com/archives/588

        // このようなエラーが出ている場合に検索をする場合は、「エラー情報」が重要になります。
        // 「java.lang.ArrayIndexOutOfBoundsException」の部分がエラーの種類ですので、検索をするとヒントが見つかりやすいです。
    }
}
