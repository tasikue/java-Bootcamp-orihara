import java.util.List;
import java.util.ArrayList;

/*
 * 課題2
 * 
 */

// ★問題よりも一つ余分に改行をしています
//   内容をご確認ください
//   「。」と「\n」では切り取り文字列の扱いが変わるはずです。「。」は含めるけど・・・
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

        List<String> tmpLine = new ArrayList<>();

        int index = 0;
        boolean isSeparatePeriod = false;

        for(int i=0; i<text.length(); i++){

            if(BoolChara.isNewLine(text, i) || BoolChara.isPeriod(text, i)){
                String separateText = text.substring(index, i+1);
                index = i+1;

                // ★フラグの管理は処理は本当に必要でしょうか？直前の文字がまるかどうか分かればいいなら
                //   もっとシンプルに書けるはずです
                // 句点の直後が改行だった場合に次の文字に行く処理
                if(BoolChara.isNewLine(text, i) && isSeparatePeriod){
                    isSeparatePeriod = false;
                    continue;
                }

                tmpLine.add(separateText);

                // 句点で区切ったときのフラグ処理
                if(BoolChara.isPeriod(text, i)){
                    isSeparatePeriod = true;
                }
            }

        }
        // 残りの文字の処理
        if(index != text.length()){
            tmpLine.add(text.substring(index, text.length()));
        }

        return tmpLine;
    }
}
