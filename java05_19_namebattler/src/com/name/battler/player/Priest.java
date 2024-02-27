package com.name.battler.player;

/**
 * 職業: 僧侶
 * job id: 2 
 */
public class Priest extends Player {

    final static int JOB_ID = 2;
    
    public Priest(){
        super(JOB_ID);
        jobName = "僧侶";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(200, 80, 50, 20, 70, 10, 70, 10, 100, 1, 60, 20);
    }

    @Override
    public void doNormalAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doNormalAttack'");
    }
}
