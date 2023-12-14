/**
 * CommaSeparatedString
 */
public class CommaSeparatedString {

    // ★全体的にコメントを付けましょう
    //   コメントのポイントは他人がプログラムを見たときに
    //   「なぜそんな書き方になったか」考える必要があるかどうかです
    //   個人的に必要と感じた行は「■」をつけました
    public static void main(String[] args) {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static String commaSeparatedString(int number){
        // ★int→Integerの変換は「オートボクシング」機能で自動的に行われるため、
        //   Integer.valueOfメソッドを使う必要はない
        // ★また、次のようにint型からそのままString型に変換する事もできます。
        //   String a = String.valueOf(number);
        Integer tmpInteger = Integer.valueOf(number);
        String strNumber = tmpInteger.toString();

        // ★LAST_DIGITという変数名は「最終桁」を連想させるため、
        //   NUMBER_LENGTHなど「桁数」を意味していることが伝わる名前が良いです
        final int LAST_DIGIT = strNumber.length();
        final String COMMA = ",";

        String setComma = "";
        for(int i = 0; i<LAST_DIGIT; i++){
            // ★この場合は書き方を省略することができます。※「+=」を使用
            //   また、substringメソッドは複数文字取り出すときに便利です
            //   １文字の場合はcharAtメソッドが有効です
            setComma = setComma + strNumber.substring(LAST_DIGIT - i - 1, LAST_DIGIT - i);
            // ■なぜこんな式なのか？をコメント
            if(i % 3 == 2){
                // ■なぜこの処理が必要か？をコメント
                if(i == LAST_DIGIT-1) continue;
                // ■なぜこの処理が必要か？をコメント
                if(strNumber.substring(LAST_DIGIT - i-2, LAST_DIGIT - i-1).equals("-")) continue;
                // ★この場合は書き方を省略することができます。※「+=」を使用
                setComma = setComma + COMMA;
            }
        }
        // ★文字列の反転にも付けるクラスがあるので参考にしてください
        //   https://www.javadrive.jp/start/stringbuilder/index7.html
        return stringReverse(setComma);
    }

    private static String stringReverse(String str){
        String tmpString = "";

        // ★上に書いた処理に影響されて、考えすぎてしまっています
        // for(int i=0; i<str.length(); i++){
        //     tmpString = tmpString + str.substring(str.length()-i-1, str.length()-i);
        // }
        // ★もう少しシンプルな実装方法
        for(int i = str.length() - 1; i >= 0; i--){
            tmpString += str.charAt(i);
        }

        return tmpString;
    }
}