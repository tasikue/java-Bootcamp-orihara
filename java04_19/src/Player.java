/*
 * プレイヤーの情報を扱うクラス
 * 
 */

public class Player {
    
    final int HP_MAX = 100;
    final int HP_MIN = 0;
    final int HINT_COUNT_MAX = 3;
    
    int hp;
    int hintCount;

    public Player(){
        this.hp = HP_MAX / 2;
        this.hintCount = HINT_COUNT_MAX;
    }

    public int getHp(){
        return this.hp;
    }

    public int getHintCount(){
        return hintCount;
    }
}
