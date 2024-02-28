package com.name.battler.player;

import com.name.battler.player.action.Heel;
import com.name.battler.player.action.Palize;
import com.name.battler.player.action.Poison;

/**
 * 職業: 僧侶
 * job id: 2 
 */
public class Priest extends Player implements Heel, Palize, Poison {

    final static int JOB_ID = 2;
    
    public Priest(){
        super(JOB_ID);
        jobName = "僧侶";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(200, 80, 50, 20, 70, 10, 70, 10, 100, 1, 60, 20);
    }

    @Override
    public void doPoisonState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doPoisonState'");
    }

    @Override
    public void doPalizeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doPalizeState'");
    }

    @Override
    public void doHeel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doHeel'");
    }
    
}
