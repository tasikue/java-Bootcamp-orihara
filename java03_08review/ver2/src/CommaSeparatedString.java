/**
 * CommaSeparatedString
 */
public class CommaSeparatedString {

    public static void main(String[] args) {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static String commaSeparatedString(int number){
        
        String strNumber = String.valueOf(number);

        final int NUMBER_LENGTH = strNumber.length();
        final String COMMA = ",";

        String setComma = "";
        for(int i = 0; i<NUMBER_LENGTH; i++){
            setComma += strNumber.charAt(NUMBER_LENGTH - i - 1);

            // 3桁毎にカンマを入れる処理
            if(i % 3 == 2){

                // 最後の桁にカンマを打たない処理
                if(i == NUMBER_LENGTH-1) continue;

                // '-'の直前にカンマを打たない処理
                if(strNumber.charAt(NUMBER_LENGTH - i-2) == '-') continue;
                
                setComma += COMMA;
            }
        }
        // ★再提出は不要ですが、この場合はiを0から始めるメリットがあまりないので
        //   1から始めたほうがすっきりします。
        //   (i % 3 == 0)も3桁ずつということが伝わりやすいと感じます。
        // for(int i = 1; i<=NUMBER_LENGTH; i++){
        //     setComma += strNumber.charAt(NUMBER_LENGTH - i);

        //     // 3桁毎にカンマを入れる処理
        //     if(i % 3 == 0){

        //         // 最後の桁にカンマを打たない処理
        //         if(i == NUMBER_LENGTH) continue;

        //         // '-'の直前にカンマを打たない処理
        //         if(strNumber.charAt(NUMBER_LENGTH - i-1) == '-') continue;
                
        //         setComma += COMMA;
        //     }
        // }
        
        return stringReverse(setComma);
    }

    private static String stringReverse(String str){
        String tmpString = "";

        for(int i = str.length() - 1; i >= 0; i--){
            tmpString += str.charAt(i);
        }

        return tmpString;
    }
}