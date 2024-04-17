/*
 * プレイヤーの情報を扱うクラス
 */

public class Player {
    
    // 定数
    /** プレイヤーの最大HP */
    private final int HP_MAX = 100;
    /** 何も食べなかった時のダメージ数 */
    private final int HUNGRY_DAMAGE = 10;
    /** 最大ヒント数 */
    private final int HINT_COUNT_MAX = 3;
    
    // 変数
    /** プレイヤーHP */
    private int hp;
    /** 生きてるかどうか */
    private boolean isLife;
    /** ヒント数 */
    private int hintCount;

    /**
     * コンストラクタ
     */
    public Player(){
        // 初期HPを最大の半分に設定
        this.hp = HP_MAX / 2;
        isLife = true;

        this.hintCount = HINT_COUNT_MAX;
    }

    public int getHp(){
        return this.hp;
    }

    public boolean getIsLife(){
        return this.isLife;
    }

    public int getHintCount(){
        return hintCount;
    }

    /**
     * プレイヤーのHPを回復する処理
     * @param heeling 回復量
     */
    public void setPlayerHp(int heeling){
        int afterHp = this.hp + heeling;
        
        // hpがmaxを超えた場合maxにする
        if(afterHp >= HP_MAX ){
            afterHp = HP_MAX;
        }
        this.hp = afterHp;
    }

    /**
     * 食べて即死した時の処理
     */
    public void instantDeath(){
        this.hp = 0;
        this.isLife = false;
    }

    /** 
     * 食べなかった時のダメージ処理
     */
    public void setHungryDamage(){
        this.hp -= HUNGRY_DAMAGE;
        
        // HP0以下で死亡
        this.isLife = this.hp >= 0;
    }

    /**
     * ヒント数から使えるかの判断
     * @return ヒントが使えるか
     */
    public boolean canUseHint(){
        if(this.hintCount > 0){
            return this.hintCount-- > 0;
        }
        return false;
    }
}
