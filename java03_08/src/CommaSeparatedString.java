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
        
        Integer tmpInteger = Integer.valueOf(number);
        String strNumber = tmpInteger.toString();

        final int LAST_DIGIT = strNumber.length();
        final String COMMA = ",";

        String setComma = "";
        for(int i = 0; i<LAST_DIGIT; i++){
            setComma = setComma + strNumber.substring(LAST_DIGIT - i - 1, LAST_DIGIT - i);
            if(i % 3 == 2){

                if(i == LAST_DIGIT-1) continue;
                if(strNumber.substring(LAST_DIGIT - i-2, LAST_DIGIT - i-1).equals("-")) continue;
                
                setComma = setComma + COMMA;
            }
        }
        
        return stringReverse(setComma);
    }

    private static String stringReverse(String str){
        String tmpString = "";

        for(int i=0; i<str.length(); i++){
            tmpString = tmpString + str.substring(str.length()-i-1, str.length()-i);
        }

        return tmpString;
    }
}