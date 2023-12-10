/**
 * StringsCompressor
 */
public class StringsCompressor {

    public static void main(String[] args) {

    String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
    System.out.println(text);
    }

    private static String encode(String text){

        char[] arrayChar = text.toCharArray();
        int count = 0;
        String outputText="";

        for(int i=1; i<text.length(); i++){
            char target = arrayChar[i];

            count++;
            // ターゲットの文字と一つ前が違う時に文字と数を追加する処理
            if(arrayChar[i-1] != target){
                outputText += arrayChar[i-1];

                if(count != 1){
                    outputText += count;
                }
                count = 0;
            }

            // 最後の文字の処理
            if(i == text.length()-1){
                outputText += arrayChar[text.length()-1];

                if(count > 0){
                    count++;
                    outputText += count;
                }
            }
        }

        return outputText;
    }
}