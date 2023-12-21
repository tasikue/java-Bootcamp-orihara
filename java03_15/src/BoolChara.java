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

    public static Boolean isNewLine(char c){
        return c == Chara.NEW_LINE.getCharacter();
    }

    public static Boolean isPeriod(char c){
        return c == Chara.PERIOD.getCharacter();
    }

    public static boolean isComma(char c){
        return c == Chara.COMMA.getCharacter();
    }
}
