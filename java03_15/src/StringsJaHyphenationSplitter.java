import java.util.ArrayList;
import java.util.List;

/*
 * 課題4
 *  
 */

public class StringsJaHyphenationSplitter {

    // final static char COMMA = '、';
    
    public static void main(String[] args) {
        
        List<String> lines =
        splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(
            "このプログラムは、句読点を行頭禁則処理するサンプル。\n"
            + "最後の行です", 8
        );

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<String> splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(String text, int split){

        List<String> inputList = StringsFixedLengthSplitter.splitFixedLengthWithLineBreakCodeAndPeriod(text, split);
        List<String> tmpList = new ArrayList<>();

        int charCount = 0;
        for(int i=0; i<inputList.size(); i++){
            String str = inputList.get(i);

            if(BoolChara.isPeriod(str, 0) || BoolChara.isComma(str, 0)){
                char tmpChar = str.charAt(0);

                // 前の行の最後に文字をつける処理
                tmpList.set(i-1, inputList.get(i-1)+tmpChar);

                charCount++;                
            }

            // 先頭の禁則文字を取り除いて前の文字を足す処理
            if(charCount > 0 && i<inputList.size()-1){
                str = 
                    inputList.get(i).substring(charCount, inputList.get(i).length())
                    + inputList.get(i+1).substring(0,charCount);
                
                if(BoolChara.isPeriod(inputList.get(i+1), charCount)){
                    str += Chara.PERIOD.getCharacter();
                    i++;
                }

                if(BoolChara.isComma(inputList.get(i+1), charCount)){
                    str += Chara.COMMA.getCharacter();
                    i++;
                }
            }

            tmpList.add(str);
        }

        return tmpList;
    }
}
