/*
 *課題のテスト用 
 * メインクラス
 * 
 */

public class App {
    public static void main(String[] args) throws Exception {
        
        TrumpManager tm = new TrumpManager();
        tm.reset();
        tm.shuffle();
        
        Trump trumpA = tm.draw();
        Trump trumpB = tm.draw();

        System.out.printf("%s %s\n", trumpA.getTrumpMark(), trumpA.getTrumpNumber());
        System.out.printf("%s %s\n", trumpB.getTrumpMark(), trumpB.getTrumpNumber());
        System.out.println(BlackJackCalc.getBlackJackScore(trumpA, trumpB));
    }
}
