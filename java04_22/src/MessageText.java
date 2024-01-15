/**
 * メッセージテキストを管理するためのクラス
 * @author orihara
 * @version 1.0
 */
public class MessageText {
    
    /** プロローグ用テキスト */
    public static void showPrologeText(){
        message("--- 遊び方 ---");
        messageln("あなたは最強のポ ◯ モンマスターを目指しています。");
        messageln("１０匹のモンスターが次々と現れてきますので、捕獲玉を使って捕獲しよう！");
        messageln("モンスターを捕獲できれば、モンスターごとに設定されたポイントを獲得できます。");
        message("３種類ある捕獲玉をうまく使って、高得点を目指そう！");
        messageln("--- --- --- --- --- --- --- --- --- ---");
    }

    private static void message(String text){
        System.out.println(text);
    }

    private static void messageln(String text){
        System.out.println(text);
        System.out.println();
    }
}
