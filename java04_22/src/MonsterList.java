import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * 出現するモンスターをまとめるクラス
 */
public class MonsterList {
    
    /** ランダムの最大値 */
    final int RANDOM_MAX = 101;
    List<Monster> monsters = new ArrayList<>();

    /** インスタンス時に出現するモンスターをセットする処理 */
    public MonsterList(){
        monsters.add(new Monster("ザコモン", 30, 20, 20, 30, 72));
        monsters.add(new Monster("フツモン", 50, 20, 30, 30, 50));
        monsters.add(new Monster("ツヨモン", 100, 50, 30, 25, 28));
        monsters.add(new Monster("ボスモン", 100, 50, 50, 10, 25));
        monsters.add(new Monster("レアモン", 150, 100, 100, 5, 14));
    }

    /** 
     * ランダムでセットしたモンスターを出力する
     * @return Monster ランダムで選ばれたモンスター
     */
    public Monster getRandomMonster(){
        Random ran = new Random();

        // 乱数(重みづけ)

        return monsters.get(ran.nextInt(monsters.size()));
    }
}
