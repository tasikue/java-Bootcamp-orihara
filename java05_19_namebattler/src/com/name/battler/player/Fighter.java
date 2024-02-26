package com.name.battler.player;

/**
 * 職業: 戦士
 * job id: 0
 */
public class Fighter extends Player{

    // 職業別パラメータ（固定値）
    AbilityRange abilityRange;

    final static int JOB_ID = 0;
    
    // コンストラクタ
    public Fighter(){
        super(JOB_ID);

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(300, 100, 0, 0, 100, 30, 100, 30, 100, 1, 50, 1);
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
    }
}
