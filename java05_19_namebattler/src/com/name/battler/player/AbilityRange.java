package com.name.battler.player;

/**
 * 能力範囲を指定するクラス
 */
public class AbilityRange {
        
    // 変数
    private int HP_MAX;
    private int HP_MIN;
    private int MP_MAX;
    private int MP_MIN;
    private int STR_MAX;
    private int STR_MIN;
    private int DEF_MAX;
    private int DEF_MIN;
    private int LUCK_MAX;
    private int LUCK_MIN;
    private int AGI_MAX;
    private int AGI_MIN;

    // コンストラクタ
    AbilityRange(int HP_MAX, int HP_MIN, int MP_MAX, int MP_MIN, int STR_MAX, int STR_MIN, int DEF_MAX, int DEF_MIN, int LUCK_MAX, int LUCK_MIN, int AGI_MAX, int AGI_MIN){
        this.HP_MAX = HP_MAX;
        this.HP_MIN = HP_MIN;
        this.MP_MAX = MP_MAX;
        this.MP_MIN = MP_MIN;
        this.STR_MAX = STR_MAX;
        this.STR_MIN = STR_MIN;
        this.DEF_MAX = DEF_MAX;
        this.DEF_MIN = DEF_MIN;
        this.LUCK_MAX = LUCK_MAX;
        this.LUCK_MIN = LUCK_MIN;
        this.AGI_MAX = AGI_MAX;
        this.AGI_MIN = AGI_MIN;
    }

    public int getHpMax(){
        return this.HP_MAX;
    }

    public int getHpMin(){
        return this.HP_MIN;
    }

    public int getMpMax(){
        return this.MP_MAX;
    }

    public int getMpMin(){
        return this.MP_MIN;
    }

    public int getStrMax(){
        return this.STR_MAX;
    }

    public int getStrMin(){
        return this.STR_MIN;
    }

    public int getDefMax(){
        return this.DEF_MAX;
    }

    public int getDefMin(){
        return this.DEF_MIN;
    }

    public int getLuckMax(){
        return this.LUCK_MAX;
    }

    public int getLuckMin(){
        return this.LUCK_MIN;
    }

    public int getAgiMax(){
        return this.AGI_MAX;
    }

    public int getAgiMin(){
        return this.AGI_MIN;
    }
}
