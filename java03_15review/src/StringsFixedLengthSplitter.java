import java.util.List;
import java.util.ArrayList;

/*
 *  課題3
 *  
 */

public class StringsFixedLengthSplitter {
    
    public static void main(String[] args) {
        
        // ★文字列の途中に「。」と「\n」入れた場合の挙動を確認してみてください。
        //   StringMoreSplitterのバグが関係しています
        List<String> lines = splitFixedLengthWithLineBreakCodeAndPeriod(
            "このプログラムは、文字列を指定された幅\nで改行するサンプルプログラムです。",
            6
        );

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<String> splitFixedLengthWithLineBreakCodeAndPeriod(String text, int split){

        List<String> inputList = StringsMoreSplitter.splitWithLineBreakCodeAndPeriod(text);
        List<String> tmpList = new ArrayList<>();

        for(int i=0; i< inputList.size(); i++) {
            String splitText = inputList.get(i);

            int count = 0;
            for (int j=1; j <= splitText.length(); j++){

                // 文字区切りで収納する処理
                if(j % split == 0){
                    tmpList.add(splitText.substring(j-split, j));
                    count++;
                }
            }

            // 最後のあまり文字の処理
            boolean isRemainder = splitText.length() - (split*count) != 0;
            if(isRemainder){
                tmpList.add(splitText.substring(split*count, splitText.length()));
            }
        }

        return tmpList;
    }
}
