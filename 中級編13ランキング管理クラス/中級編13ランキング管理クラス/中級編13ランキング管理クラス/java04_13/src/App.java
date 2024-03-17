/*
 * javabootcamp04-13 ランキング管理クラス
 * 実行用メイン関数
 * 
 */

public class App {

    public static void main(String[] args) throws Exception {
        
        showProblemOne();
        showProblemTwe();
    }

    // 課題1
    private static void showProblemOne(){
        Ranking ranking = new Ranking();
        ranking.EntryScore(300);
        ranking.EntryScore(100);
        ranking.EntryScore(400);
        ranking.EntryScore(200);
        ranking.PrintRanking();
    }

    // 課題2
    private static void showProblemTwe(){
        Ranking ranking = new Ranking();
        ranking.EntryScore(300, "name300");
        ranking.EntryScore(100, "name100");
        ranking.EntryScore(400, "name400");
        ranking.EntryScore(200, "name200");
        ranking.PrintRanking();
    }

    // private static void showProblemOne(){
    //     RankingSample ranking = new RankingSample();
    //     ranking.EntryScore(300);
    //     ranking.EntryScore(100);
    //     ranking.EntryScore(400);
    //     ranking.EntryScore(200);
    //     ranking.PrintRanking();
    // }

    // private static void showProblemTwe(){
    //     RankingSample ranking = new RankingSample();
    //     ranking.EntryScore(300, "name300");
    //     ranking.EntryScore(100, "name100");
    //     ranking.EntryScore(400, "name400");
    //     ranking.EntryScore(200, "name200");
    //     ranking.PrintRanking();
    // }
}
