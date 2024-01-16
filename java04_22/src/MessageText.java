/**
 * メッセージテキストを管理するためのクラス
 * @author orihara
 * @version 1.0
 */
public class MessageText {
    
    /** プロローグテキスト */
    public static void showPrologeText(){
        message("--- 遊び方 ---");
        messageln("あなたは最強のポ ◯ モンマスターを目指しています。");
        messageln("１０匹のモンスターが次々と現れてきますので、捕獲玉を使って捕獲しよう！");
        messageln("モンスターを捕獲できれば、モンスターごとに設定されたポイントを獲得できます。");
        message("３種類ある捕獲玉をうまく使って、高得点を目指そう！");
        messageln("--- --- --- --- --- --- --- --- --- ---");
    }

    /** スタンバイフェイズ */
    public static void showStanbyPhaseText(){
        messageln("あなたは草むらに繰り出した！");
        messageln("ガサゴソ....ガサゴソ...ガサゴソ.......");
        messageln("... ... ... !!");
        messageln("草むらから何かが飛び出した！");
    }

    /** バトルフェイズ */
    public static void showBattlePhaseText(Monster monster){
        messageln("%s が現れた！", monster.getName());
    }

    /** メッセージ表示（改行なし） */
    private static void message(String text){
        System.out.println(text);
    }

    /** メッセージ表示（改行あり） */
    private static void messageln(String text){
        System.out.println(text);
        System.out.println();
    }

    /** メッセージ表示（改行あり）
     * @param text 表示するテキスト
     * @param name テキストに組み込む文字列の変数
     */
    private static void messageln(String text, String name){
        System.out.printf(text +"\n", name);
        System.out.println();
    }
}
