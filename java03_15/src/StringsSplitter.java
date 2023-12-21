 import java.util.List ;
 import java.util.ArrayList;

/*
 * 課題1
 * 
 */

public class StringsSplitter {
    
    public static void main(String[] args) {
        
        List<String> lines = splitWithLineBreakCode(
            "１行目。\n２行目。\n３行目。\n４行目。\n\n５行目\n"
        );

        for (String line : lines) {
            System.out.println(line);
        }
    }
    
    public static List<String> splitWithLineBreakCode(String text){

        List<String> splittedLine = new ArrayList<>();

        int index = 0;
        for(int i=0; i<text.length(); i++){

            char targetChar = text.charAt(i);
            if(BoolChara.isNewLine(targetChar)){
                String separateText = text.substring(index, i);
                index = i+1;
                
                splittedLine.add(separateText);
            }
        }
        // 残りの文字の処理
        if(index != text.length()){
            splittedLine.add(text.substring(index, text.length()));
        }

        return splittedLine;
    }
}
