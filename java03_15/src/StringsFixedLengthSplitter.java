import java.util.List;
import java.util.ArrayList;

/*
 *  課題3
 *  
 */

public class StringsFixedLengthSplitter {
    
    public static void main(String[] args) {
        
        List<String> lines = splitFixedLengthWithLineBreakCodeAndPeriod(
            "このプログラムは、文字列を指定された幅で改行するサンプルプログラムです。",
            6
        );

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<String> splitFixedLengthWithLineBreakCodeAndPeriod(String text, int split){

        List<String> inputList = StringsMoreSplitter.splitWithLineBreakCodeAndPeriod(text);
        List<String> splittedLine = new ArrayList<>();

        for(int i=0; i< inputList.size(); i++) {
            String splitText = inputList.get(i);

            int count = 0;
            for (int j=1; j <= splitText.length(); j++){

                // 文字区切りで収納する処理
                if(j % split == 0){
                    splittedLine.add(splitText.substring(j-split, j));
                    count++;
                }
            }

            // 最後のあまり文字の処理
            boolean isRemainder = splitText.length() - (split*count) != 0;
            if(isRemainder){
                splittedLine.add(splitText.substring(split*count, splitText.length()));
            }
        }

        return splittedLine;
    }
}
