import java.util.List;
import java.util.ArrayList;

/*
 * 課題2
 * 
 */

public class StringsMoreSplitter {

    public static void main(String[] args) {

        List<String> lines = splitWithLineBreakCodeAndPeriod(
            "１行目。２行目。\n３行目。４行目。\n\n５行目。"
        );

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<String> splitWithLineBreakCodeAndPeriod(String text){

        List<String> inputList = StringsSplitter.splitWithLineBreakCode(text);
        List<String> splittedLine = new ArrayList<>();

        for(int i=0; i<inputList.size(); i++){
            int index = 0;
            int countChar = 0;

            for(int j=0; j<inputList.get(i).length(); j++){
                char targetChar = inputList.get(i).charAt(j);
                countChar++;

                // 句点で入力する処理
                if(BoolChara.isPeriod(targetChar)){
                    String separateText = inputList.get(i).substring(index, j+1);
                    index = j+1;

                    splittedLine.add(separateText);
                    countChar = 0;
                }
            }

            // 残りの文字の処理
            if(countChar != 0){
                splittedLine.add(inputList.get(i).substring(index, countChar));

                index = countChar;
                countChar = 0;
            }

            if(inputList.get(i) == ""){
                splittedLine.add("");
                // continue;
            }
            
            // 前に。がある時の処理だけど…
            /*
            if(! BoolChara.isPeriod(inputList.get(i).charAt(index-1))){
                // splittedLine.add("改行");
            }*/
        }

        return splittedLine;
    }
}
