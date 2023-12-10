/**
 * StringsExpander
 */
public class StringsExpander {

    public static void main(String[] args) {
        // ★展開対象の文字列が数値で終わる場合はどうなりますか？
        String text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String decode(String text){

        String decodeText = "";
        char target = ' ';
        char[] arrayChar = text.toCharArray();
        boolean isSetting = false;

        for(int i=0; i<text.length(); i++){
            if(!isNumber(arrayChar[i])){
                // {}は省略せずに「+=」を使う
                if(isSetting) decodeText = decodeText + target;

                target = arrayChar[i];
                isSetting = true;
                continue;
            }
            isSetting = false;
 
            int countNumber = Integer.parseInt(splitNumber(text.substring(i, text.length())));

            for(int j=0; j<countNumber; j++){
                decodeText = decodeText + target;
            }
        }

        // ★「+=」を使う
        decodeText = decodeText + arrayChar[text.length() - 1];
        return decodeText;
    }

    // ★isNumberメソッドを作る必要性をあまり感じません
    //   メソッドないでやっている処理CharacterクラスのisDigitメソッドを呼び出すことだけですので、
    //   メソッド化の利点はあまりないかと思われます
    private static boolean isNumber(char c){
        return Character.isDigit(c);
    }

    private static String splitNumber(String text){

        String number= "";

        for(int i=0; i<text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                //　★「+=」を使用
                number = number + text.substring(i, i+1);
            } else {
                // ここはbreakが良いです return は最後に行っていますので
                // 同じ意味のプログラムを個々に書く必要はないです
                return number;
            }
        }
        return number;
    }
}
