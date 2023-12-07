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
        char target = ' ';
        String outputText="";

        for(int i=1; i<text.length(); i++){
            target = arrayChar[i];

            if(arrayChar[i-1] == target){
                count++;
            } else {
                count++;
                outputText = outputText + arrayChar[i-1];

                if(count != 1) outputText = outputText + count;

                count = 0;
            }
        }

        outputText = outputText + arrayChar[text.length()-1];
        return outputText;
    }
}