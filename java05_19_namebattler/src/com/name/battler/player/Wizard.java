package com.name.battler.player;

/**
 * 職業: 魔法使い
 * job id: 1
 */
public class Wizard extends Player{

    // 職業別パラメータ（固定値）
    AbilityRange abilityRange;

    final static int JOB_ID = 1;

    // コンストラクタ
    public Wizard(){
        super(JOB_ID);

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(150, 50, 80, 30, 50, 1, 50, 1, 100, 1, 60, 20);
    }

    /**
     * 
     * @return それぞれの能力値範囲
     */
    public AbilityRange getAbilityRange(){
        return abilityRange;
    }

    @Override
    public void doNormalAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doNormalAttack'");
    }
}
