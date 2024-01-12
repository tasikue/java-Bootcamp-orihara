public class BlackJackCalc {

    final static int ONE_POINT = 1; 
    final static int TEN_POINT = 10;
    final static int ELEVEN_POINT = 11;
    final static int BLACKJACK = 21;
    
    public static int getBlackJackScore(Trump A, Trump B){

        int scoreA = getScore(A);
        int scoreB = getScore(B);

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

    // Aかどうかの処理
    private static boolean isA(int score){
        if(score == ONE_POINT){
            return true;
        }
        return false;
    }

    // 片方がAのとき合計を出力する処理
    private static int getAPlusScore(int score){
        // 22以上の場合
        if(ELEVEN_POINT + score > BLACKJACK){
            return ONE_POINT + score;
        }
        return ELEVEN_POINT + score;
    }

    // トランプの点数を出力する
    private static int getScore(Trump X){

        switch(X.getTrumpNumber()){
            case "A":
            return 1;
            case "J", "Q", "K":
            return 10;
            default:
            return Integer.valueOf(X.getTrumpNumber());
        }
    }
}
