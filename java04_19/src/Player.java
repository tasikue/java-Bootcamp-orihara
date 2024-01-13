/*
 * プレイヤーの情報を扱うクラス
 * 
 */

public class Player {
    
    final int HP_MAX = 100;
    final int HP_MIN = 0;
    final int HUNGRY_DAMAGE = 10;
    final int HINT_COUNT_MAX = 3;
    
    int hp;
    int hintCount;

    public Player(){
        this.hp = HP_MAX / 2;
        this.hintCount = HINT_COUNT_MAX;
    }

    // 食べることができたときのダメージ計算
    public boolean isDeadCalcHp(int hungry){
        int afterHp = this.hp + hungry;
        boolean downMin = afterHp <= HP_MIN;
        
        // hpがmaxを超えた場合maxにする
        if(afterHp >= HP_MAX ){
            afterHp = HP_MAX;
        }

        this.hp = afterHp;
        return downMin;
    }

    // 食べて死んだときのダメージ計算
    public boolean isDeadZeroHp(){
        this.hp = 0;
        return true;
    }

    // 食べなかった時のダメージ計算
    public boolean isDeadCalcHp(){
        this.hp -= HUNGRY_DAMAGE;
        return this.hp <= 0;
    }

    // ヒント使用時
    public boolean isCanUseHint(){
        if(this.hintCount > 0){
            return this.hintCount-- > 0;
        }
        return false;
    }

    public int getHp(){
        return this.hp;
    }

    public int getHintCount(){
        return hintCount;
    }
}
