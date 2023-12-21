import java.util.ArrayList;
import java.util.List;

/*
 * 課題4
 *  
 */

public class StringsJaHyphenationSplitter {
    
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
        List<String> splittedLine = new ArrayList<>();

        int charCount = 0;
        int periodSkipCount = 0;
        for(int i=0; i<inputList.size(); i++){
            String str = inputList.get(i);

            // 前の行の最後に文字を足す処理
            char firstChar = str.charAt(0);
            if(BoolChara.isPeriod(firstChar) || BoolChara.isComma(firstChar)){
                char tempChar = str.charAt(0);

                splittedLine.set(i-1-periodSkipCount, inputList.get(i-1)+tempChar);
                charCount++;
            }

            // 句点しかないときに
            if(str.length() <= charCount){
                continue;
            }

            // 先頭の禁則文字を取り除いて前の文字を足す処理
            boolean hasNextList = i<inputList.size()-1;
            if(charCount > 0 && hasNextList){
                String nextStr = inputList.get(i+1);
                
                str = str.substring(charCount, str.length());

                if(!BoolChara.isPeriod(str.charAt(str.length()-1))){
                    str += nextStr.substring(0, charCount);
                }

                // 句点で改行されるときの処理
                if(BoolChara.isPeriod(str.charAt(str.length()-1))){
                    charCount = 0;
                }
                
                // 次の行に句読点だけにならないようにする処理
                char inputChar = nextStr.charAt(charCount);
                if(BoolChara.isPeriod(inputChar)){
                    if(!BoolChara.isPeriod(str.charAt(str.length()-1))){
                        str += Chara.PERIOD.getCharacter();
                    }
                    periodSkipCount++;
                    i++;
                }

                if(BoolChara.isComma(inputChar)){
                    str += Chara.COMMA.getCharacter();
                    periodSkipCount++;
                    i++;
                }
            }

            splittedLine.add(str);
        }

        return splittedLine;
    }
}
