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

    // ★名前付きとそうでない場合の対応で複雑化しましたが、
    //   別々管理しなくて済むような書き方をサンプルとして作りました(RankingSample)
    // scoreを入れるリストを用意する
    List<String> scoreList = new ArrayList<>();
    List<Score> scoreBook = new ArrayList<>();

    // 課題1: Listにscoreを入れて降順にソートする
    public void EntryScore(int score){

        // scoreを文字列で収納しソートする
        scoreList.add(String.valueOf(score));
        Collections.sort(scoreList, Collections.reverseOrder());
    }


    // 課題2: Scoreクラスに収納
    public void EntryScore(int point, String name){
        // pointとnameをscoreクラスとしてListに入れる
        scoreBook.add(new Score(point, name));

        // pointでソートする
        sortPointFromBookToList();
        // nameを足す
        addNameToScoreList();
    }

    /**
     * scoreBookをpointで降順ソートしてscoreListに入れる処理
     */
    private void sortPointFromBookToList(){

        scoreList.clear();
        // pointを降順で入れる
        for(Score score: scoreBook){
            EntryScore(score.getPoint());
        }
    }

    /**
     * nameを足した文字列にする処理
     * 先にpointだけ入れたscoreListにscoreBookからnameを足す
     */
    private void addNameToScoreList(){

        for(Score score: scoreBook){
            for(int i=0; i<scoreList.size(); i++){

                // name + point
                String text = score.getNameAndPoint(scoreList.get(i));
                if(text != null){
                    // 同じpointの位置にnameを足す
                    scoreList.set(i, text);
                }
            }
        }
    }

    /**
     * 入力したものをすべて出力する
     */
    public void PrintRanking(){

        for(int i=0; i<scoreList.size(); i++){
            
            System.out.printf("%d 位: %s \n",
                i+1, scoreList.get(i));
        }
    }
 }