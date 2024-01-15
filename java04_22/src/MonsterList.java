import java.util.List;
import java.util.ArrayList;

/**
 * 出現するモンスターをまとめるクラス
 */
public class MonsterList {
    
    List<Monster> monsters = new ArrayList<>();

    /** 出現するモンスターをセットする処理 */
    public void setMonsters(){
        monsters.add(new Monster("ザコモン", 30, 20, 20, 30, 72));
        monsters.add(new Monster("フツモン", 50, 20, 30, 30, 50));
        monsters.add(new Monster("ツヨモン", 100, 50, 30, 25, 28));
        monsters.add(new Monster("ボスモン", 100, 50, 50, 10, 25));
        monsters.add(new Monster("レアモン", 150, 100, 100, 5, 14));
    }
}
