package com.name.battler.player.job;

import com.name.battler.setting.Range;

/**
 * ジョブのパラメータをまとめるクラス
 */
public enum JobParameter {
    
    // 定数
    /** 戦士のパラメータ */
    FIGHTER_PARAMETTER(100, 300, 0, 0, 30, 100, 30, 100, 1, 100, 1, 50),
    /** 魔法使いのパラメータ */
    WIZARD_PARAMETTER(50, 150, 30, 80, 1, 50, 1, 50, 1, 100, 20, 60),
    /** 僧侶のパラメータ */
    PRIEST_PARAMETTER(80, 200, 20, 50, 10, 70, 10, 70, 1, 100, 20, 60),
    /** 僧侶のパラメータ */
    HERO_PARAMETTER(100, 250, 0, 40, 30, 80, 30, 80, 30, 100, 10, 50);

    // 変数
    /** HPの範囲 */
    private Range hp;
    /** MPの範囲 */
    private Range mp;
    /** 攻撃力範囲 */
    private Range str;
    /** 防御力範囲 */
    private Range def;
     /** 幸運度の範囲 */
    private Range luck;
    /** 素早さの範囲 */
    private Range agi;

    /**
     * 職業のパラメータを設定するコンストラクタ
     * @param hpMin hpの最小値
     * @param hpMax hpの最大値
     * @param mpMin mpの最小値
     * @param mpMax mpの最大値
     * @param strMin 攻撃力の最小値
     * @param strMax 攻撃力の最大値
     * @param defMin 防御力の最小値
     * @param defMax 防御力の最大値
     * @param luckMin 幸運の最小値
     * @param luckMax 幸運の最大値
     * @param agiMin 素早さの最小値
     * @param agiMax 素早さの最大値
     */
    JobParameter(
        int hpMin, int hpMax,
        int mpMin, int mpMax,
        int strMin, int strMax,
        int defMin, int defMax,
        int luckMin, int luckMax,
        int agiMin, int agiMax){

        this.hp = new Range(hpMin, hpMax);
        this.mp = new Range(mpMin, mpMax);
        this.str = new Range(strMin, strMax);
        this.def = new Range(defMin, defMax);
        this.luck = new Range(luckMin, luckMax);
        this.agi = new Range(agiMin, agiMax);
    }

    /* --- メソッド --- */
    /**
     * HPのパラメータを取得する処理
     * @return HPのパラメータ
     */
    public Range getHpRange(){
        return this.hp;
    }

    /**
     * MPのパラメータを取得する処理
     * @return MPのパラメータ
     */
    public Range getMpRange(){
        return this.mp;
    }

    /**
     * 攻撃力のパラメータを取得する処理
     * @return 攻撃力のパラメータ
     */
    public Range getStrRange(){
        return this.str;
    }

    /**
     * 防御力のパラメータを取得する処理
     * @return 防御力のパラメータ
     */
    public Range getDefRange(){
        return this.def;
    }

    /**
     * 幸運のパラメータを取得する処理
     * @return 幸運のパラメータ
     */
    public Range getLuckRange(){
        return this.luck;
    }

    /**
     * 素早さのパラメータを取得する処理
     * @return 素早さのパラメータ
     */
    public Range getAgiRange(){
        return this.agi;
    }
}