package com.name.battler.player;

/**
 * 職業: 戦士
 * job id: 0
 */
public class Fighter extends Player{

    final static int JOB_ID = 0;
    
    // コンストラクタ
    public Fighter(){
        super(JOB_ID);
        jobName = "戦士";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(300, 100, 0, 0, 100, 30, 100, 30, 100, 1, 50, 1);
    }

    @Override
    public void doNormalAttack() {
    }
}
