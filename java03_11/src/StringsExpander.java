/**
 * StringsExpander
 */
public class StringsExpander {

    public static void main(String[] args) {
        
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

        decodeText = decodeText + arrayChar[text.length() - 1];
        return decodeText;
    }

    private static boolean isNumber(char c){
        return Character.isDigit(c);
    }

    private static String splitNumber(String text){

        String number= "";

        for(int i=0; i<text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                number = number + text.substring(i, i+1);
            } else {
                return number;
            }
        }
        return number;
    }
}
