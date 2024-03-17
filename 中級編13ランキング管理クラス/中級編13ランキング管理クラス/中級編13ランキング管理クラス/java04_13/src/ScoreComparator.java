import java.util.Comparator;

// ★Comparatorはちょっとだけ高度な技術なので
//   参考情報を貼っておきます
//   参考：https://java.keicode.com/lib/collections-sort.php
//   参考：https://www.geeksforgeeks.org/sort-arraylist-in-descending-order-using-comparator-in-java/

public class ScoreComparator implements Comparator<ScoreSample>{
    @Override
    public int compare(ScoreSample s1, ScoreSample s2){
        return s2.getPoint() - s1.getPoint();
        // ★昇順にしたい場合は
        // return s1.getPoint() - s2.getPoint();
    }
}
