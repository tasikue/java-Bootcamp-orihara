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

        List<String> tmpLine = new ArrayList<>();

        int index = 0;
        for(int i=0; i<text.length(); i++){

            if(BoolChara.isNewLine(text, i)){
                String separateText = text.substring(index, i);
                index = i+1;
                
                tmpLine.add(separateText);
            }
        }

        return tmpLine;
    }
}
