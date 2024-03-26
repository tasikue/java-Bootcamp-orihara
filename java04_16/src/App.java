/*
 *課題のテスト用 
 * メインクラス
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {
        
        TrumpManager tm = new TrumpManager();
        BlackJackCalc bjc = new BlackJackCalc();
        
        // トランプをリセットしてシャッフル 
        tm.reset();
        tm.shuffle();
        
        // ２枚トランプを引く
        Trump trumpA = tm.draw();
        Trump trumpB = tm.draw();

        // 引いたトランプとその合計得点を表示
        System.out.printf("%s %s\n", trumpA.getMark(), trumpA.toString());
        System.out.printf("%s %s\n", trumpB.getMark(), trumpB.toString());
        System.out.println(bjc.getBlackJackScore(trumpA, trumpB));
    }
}
