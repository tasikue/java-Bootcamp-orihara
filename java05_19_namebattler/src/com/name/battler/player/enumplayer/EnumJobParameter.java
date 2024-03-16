package com.name.battler.player.enumplayer;

import com.name.battler.setting.Range;

/**
 * ジョブのパラメータをまとめるクラス
 */
public enum EnumJobParameter {
    
    // 定数
    FIGHTER_PARAMETTER(100, 300, 0, 0, 30, 100, 30, 100, 1, 100, 1, 50),
    WIZARD_PARAMETTER(50, 150, 30, 80, 1, 50, 1, 50, 1, 100, 20, 60),
    PRIEST_PARAMETTER(80, 200, 20, 50, 10, 70, 10, 70, 1, 100, 20, 60);

    // 変数
    Range hp;
    Range mp;
    Range str;
    Range def;
    Range luck;
    Range agi;

    /**
     * 職業のパラメータを設定するコンストラクタ
     * Rageクラスで上限下限でまとめている
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
    EnumJobParameter(
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
     * HPのパラメータを出力する処理
     * @return HPのパラメータ
     */
    public Range getHpRange(){
        return this.hp;
    }

    /**
     * MPのパラメータを出力する処理
     * @return MPのパラメータ
     */
    public Range getMpRange(){
        return this.mp;
    }

    /**
     * 攻撃力のパラメータを出力する処理
     * @return 攻撃力のパラメータ
     */
    public Range getStrRange(){
        return this.str;
    }

    /**
     * 防御力のパラメータを出力する処理
     * @return 防御力のパラメータ
     */
    public Range getDefRange(){
        return this.def;
    }

    /**
     * 幸運のパラメータを出力する処理
     * @return 幸運のパラメータ
     */
    public Range getLuckRange(){
        return this.luck;
    }

    /**
     * 素早さのパラメータを出力する処理
     * @return 素早さのパラメータ
     */
    public Range getAgiRange(){
        return this.agi;
    }
}