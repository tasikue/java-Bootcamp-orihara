import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 public class RankingSample {
    List<ScoreSample> scores = new ArrayList<>();

    public void EntryScore(int score){
        scores.add(new ScoreSample(score, null));
    }

    public void EntryScore(int point, String name){
        scores.add(new ScoreSample(point, name));
    }

    // ★ソートではなく、新しい要素を追加するときに
    // 挿入位置を決めて挿入方法でも対応可
    private void sortScore(){
        // Collections.sort(scores, new ScoreComparator());

        // ★後からでたJavaの機能を使うと上のことをいろいろ省略できて
        //   わざわざクラスを作らなくて済みます。
        //   ただし、大分上級者向けです
        //   参考：https://www.techiedelight.com/ja/sort-list-of-objects-using-comparator-java/
        
        // ★方法①
        // Comparator<ScoreSample> scoreComparator = new Comparator<ScoreSample>(){
        //     @Override
        //     public int compare(ScoreSample s1, ScoreSample s2){
        //         return s2.getPoint() - s1.getPoint();
        //     }
        // };
        // Collections.sort(scores, scoreComparator);

        // ★方法②
        Comparator<ScoreSample> scoreComparator = Comparator.comparing(ScoreSample::getPoint,Comparator.reverseOrder());
        Collections.sort(scores, scoreComparator);
    }

    // ★表示だけ工夫すれば名前つきのときとそうでないときを混合できます
    public void PrintRanking(){
        sortScore();

        for(int i=0; i<scores.size(); i++){
            ScoreSample score = scores.get(i);

            System.out.printf("%d 位: ", i + 1);

            if(score.getName() != null){
                System.out.printf("%s ", score.getName());
            }

            System.out.printf("%d\n", score.getPoint());
        }
    }
 }