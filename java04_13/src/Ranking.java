import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/*
 * javabootcamp04-13 ランキング管理クラス
 * 課題1・2
 * 
 * Ranking.java
 */

 public class Ranking {

    List<String> scoreList = new ArrayList<>();
    List<Score> scoreBook = new ArrayList<>();

    // 課題1: Listにスコアを入れて降順にソートする
    public void EntryScore(int score){

        scoreList.add(String.valueOf(score));
        Collections.sort(scoreList, Collections.reverseOrder());
    }


    // 課題2: Scoreクラスに収納
    public void EntryScore(int point, String name){
        scoreBook.add(new Score(point, name));

        sortPointFromBookToList();
        addNameToScoreList();
    }

    // scoreBookをpointで降順ソートしてscoreListに入れる処理
    private void sortPointFromBookToList(){

        scoreList.clear();
        for(Score score: scoreBook){
            EntryScore(score.getPoint());
        }
    }

    // nameを足した文字列にする処理
    private void addNameToScoreList(){

        for(Score score: scoreBook){
            for(int i=0; i<scoreList.size(); i++){

                String text = score.getNameAndPoint(scoreList.get(i));
                if(text != null){
                    scoreList.set(i, text);
                }
            }
        }
    }

    
    public void PrintRanking(){

        for(int i=0; i<scoreList.size(); i++){
            
            System.out.printf("%d 位: %s \n",
                i+1, scoreList.get(i));
        }
    }
 }