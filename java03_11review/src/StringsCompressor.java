/**
 * StringsCompressor
 */
public class StringsCompressor {

    public static void main(String[] args) {

    // ★圧縮対象の文字列の最後が２文字の場合は実行結果どうなりますか？
    // 　例）String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFGG");
    String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
    System.out.println(text);
    }

    private static String encode(String text){

        char[] arrayChar = text.toCharArray();
        int count = 0;
        // ★変数の宣言場所について「スコープ」が一番短くなるようにお願いします　※①
        char target = ' ';
        String outputText="";

        for(int i=1; i<text.length(); i++){
            // ★ここで宣言する　※①
            target = arrayChar[i];

            // ★そもそもtargetは個々でしか使われていないので、
            //   変数に入れずにそのまま比較をしましょう
            // ★if分のtrueとfalse両方でcountをインクリメントしているため、
            //   今回の場合はif文の前に持ってくるのが正しい
            // if(arrayChar[i-1] == target){
            //     count++;
            // } else {
            //     count++;
            //     // ★「+=」を活用する
            //     outputText = outputText + arrayChar[i-1];
            //     // ★if文の中括弧なしで書くのは、ダメとしている案件先もあります（派閥が分かれる書き方の１つです）
            //     if(count != 1) outputText = outputText + count;

            //     count = 0;
            // }
            // ★以下は直した結果です
            count++;
            if(arrayChar[i-1] != target){
                outputText += arrayChar[i-1];

                if(count != 1){
                    outputText += count;
                } 

                count = 0;
            }
        }
        // 「+=を使う」
        outputText = outputText + arrayChar[text.length()-1];
        return outputText;
    }
}