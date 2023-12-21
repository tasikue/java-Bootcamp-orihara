/*
 * 特殊文字と
 * 文字列中のそれはにその文字かどうか判定する
 * メソッドをまとめてるクラス
 * 
 */

enum Chara {
    NEW_LINE('\n'),
    PERIOD('。'),
    COMMA('、'),
    ;

    private char character;

    Chara(char charcter){
        this.character = charcter;
    }

    public char getCharacter(){
        return this.character;
    }
 }

public class BoolChara {

    // ★引数として文字を受け取って結果を返す形が一番汎用性が高いです
    //   文字を取り出す処理は呼び出し側で実施できる内容です
    public static Boolean isNewLine(String text, int i){
        return text.charAt(i) == Chara.NEW_LINE.getCharacter();
    }

    public static Boolean isPeriod(String text, int i){
        return text.charAt(i) == Chara.PERIOD.getCharacter();
    }

    public static boolean isComma(String text, int i){
        return text.charAt(i) == Chara.COMMA.getCharacter();
    }
}
