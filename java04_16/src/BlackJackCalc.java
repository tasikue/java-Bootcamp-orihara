/**
 * javabootcamp 04-16
 * 課題3
 */
public class BlackJackCalc {

    // 変数
    /** 1点 */
    final static int ONE_POINT = 1;
    /** 10点 */
    final static int TEN_POINT = 10;
    /** 11点 */
    final static int ELEVEN_POINT = 11;
    /** ブラックジャック時の点数 */
    final static int BLACKJACK = 21;
    
    /**
     * ２枚のカードを引数として受け取り、点数を数えて返す
     * @param A 1枚目のトランプ
     * @param B 2枚目のトランプ
     * @return カードの点数
     */
    public int getBlackJackScore(Trump A, Trump B){

        // 個々のトランプの点数
        int scoreA = getScore(A);
        int scoreB = getScore(B);

        // トランプがAかどうか
        boolean isAofTrumpA = isA(scoreA);
        boolean isAofTrumpB = isA(scoreB);

        // 両方A
        if(isAofTrumpA && isAofTrumpB){
            return ELEVEN_POINT + ONE_POINT;
        }

        // TrumpAがA
        if(isAofTrumpA){
            return getAPlusScore(scoreB);
        }

        // TrumpBがA
        if(isAofTrumpB){
            return getAPlusScore(scoreA);
        }

        // どちらもAじゃない
        return scoreA + scoreB;
    }

    /**
     * Aかどうかの処理
     * @param score カードの点数
     * @return Aなら正
     */
    private boolean isA(int score){

        // カードの点数が1だったとき
        if(score == ONE_POINT){
            return true;
        }
        return false;
    }

    /**
     * 片方がAのとき合計を出力する処理
     * @param score Aじゃない方のカードの点数
     * @return 2枚の合計点数 
     */
    private int getAPlusScore(int score){

        // 22以上の場合
        if(ELEVEN_POINT + score > BLACKJACK){
            return ONE_POINT + score;
        }

        // 22以下の時
        return ELEVEN_POINT + score;
    }

    /**
     * トランプの点数を出力する 
     * @param X トランプカード
     * @return 点数
     */
    private int getScore(Trump X){

        // 数値文字列で判断する
        switch(X.toString()){
            // Aのとき
            case "A":
                return 1;

            // J, Q, Kのとき
            case "J", "Q", "K":
                return 10;
            
            // その他
            default:
                return X.getNumber();
        }
    }
}
