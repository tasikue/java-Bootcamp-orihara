package com.name.battler.player;

import com.name.battler.player.action.Fire;
import com.name.battler.player.action.Thunder;

/**
 * 職業: 魔法使い
 * job id: 1
 */
public class Wizard extends Player implements Fire, Thunder {

    final static int JOB_ID = 1;

    // コンストラクタ
    public Wizard(){
        super(JOB_ID);
        jobName = "魔法使い";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(150, 50, 80, 30, 50, 1, 50, 1, 100, 1, 60, 20);
    }

    @Override
    public int doThunderAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doThunderAttack'");
    }

    @Override
    public int doFireAttack() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doFireAttack'");
    }
}
