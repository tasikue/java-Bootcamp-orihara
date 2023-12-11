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
            
            // 数字ではないときの処理
            if(!Character.isDigit(arrayChar[i])){
                // 一文字しかない場合の処理
                if(isSetting) {
                    decodeText += target;
                }

                target = arrayChar[i];

                // 最後の一文字の処理
                if(i == text.length()-1){
                    decodeText += target;
                }

                isSetting = true;
                continue;
            }
            isSetting = false;
 
            int countNumber = Integer.parseInt(splitNumber(text.substring(i, text.length())));

            // 回数分文字を入れる処理
            for(int j=0; j<countNumber; j++){
                decodeText += target;
            }
        }
        
        return decodeText;
    }

    private static String splitNumber(String text){

        String number= "";

        for(int i=0; i<text.length(); i++){
            if(Character.isDigit(text.charAt(i))){
                number += text.substring(i, i+1);
            } else {
                break;
            }
        }
        return number;
    }
}
