/*
 * プレイヤーの情報を扱うクラス
 */

public class Player {
    
    // 定数
    /** プレイヤーの最大HP */
    private final int HP_MAX = 100;
    /** 何も食べなかった時のダメージ数 */
    // ★HUNGRY→HUNGERが良いのでは?
    private final int HUNGRY_DAMAGE = 10;
    /** 最大ヒント数 */
    private final int HINT_COUNT_MAX = 3;
    
    // 変数
    /** プレイヤーHP */
    private int hp;
    /** 生きてるかどうか */
    // ★isAliveが良いのでは
    //   ただし都度判定すればよいのではないかと思います
    // ★フラグは便利ですが、使わないほうが効率的に読みやすい場合も多いです
    //   そして、フラグは更新し忘れるとバグのもとになるので注意が必要です
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

    // ★サンプル
    // public boolean isAlive(){
    //     return this.hp > 0;
    // }

    public int getHintCount(){
        return hintCount;
    }

    /**
     * プレイヤーのHPを回復する処理
     * @param heeling 回復量
     */
    // ★set〇〇はオブジェクト指向で
    //   受け取った値をそのままフィールドに設定するときによく使います
    //   この場合は足しているわけなのでhealHpなどが良いです
    public void setPlayerHp(int heeling){
        int afterHp = this.hp + heeling;
        
        // hpがmaxを超えた場合maxにする
        // ★細かいことですが「=」は不要
        if(afterHp >= HP_MAX ){
            afterHp = HP_MAX;
        }
        this.hp = afterHp;
    }

    // ★この書き方もありかと思います。
    //   ただし作成するものによっては一瞬でも変数の値が
    //   論理的におかしい数値になってはいけない場面もあるので、
    //   その場合は上の処理が良いです。
    //   ゲーム制作などで下の書き方を使うと一瞬だけ表示がバグるなどの
    //   不具合を見たことがあります
    // public void setPlayerHp(int heeling){
    //     this.hp += heeling;
        
    //     // hpがmaxを超えた場合maxにする
    //     // ★細かいことですが「=」は不要
    //     if(this.hp >= HP_MAX ){
    //         this.hp = HP_MAX;
    //     }
    // }

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
    // ★set〇〇は上で書いたような意味になるので
    //   takeHungerDamageなどが良いのでは
    public void setHungryDamage(){
        this.hp -= HUNGRY_DAMAGE;
        
        // HP0以下で死亡
        // ★「＝」なし
        this.isLife = this.hp >= 0;
    }

    /**
     * ヒント数から使えるかの判断
     * @return ヒントが使えるか
     */
    // ★これはバグの元になりやすいプログラムです
    //   メソッド名がcanUseHintですので
    //   呼び出す人はヒントが使えるかどうかのチェックだけをしてくれるかと思いきや
    //   ヒント回数を消費してしまう
    //   使えるかのチェックとヒントを使う処理を分けると良い
    public boolean canUseHint(){
        if(this.hintCount > 0){
            return this.hintCount-- > 0;
        }
        return false;
    }
}
