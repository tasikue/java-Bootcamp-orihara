package com.name.battler.player.job;

import com.name.battler.player.Player;
import com.name.battler.setting.AbilityRange;

/**
 * 職業: 戦士クラス
 */
public class Fighter extends Player{

    /**
     * 職業の戦士を設定するコンストラクタ
     * 
     * ジョブID -> 0
     * ジョブ名 -> 戦士
     * ジョブパラメータ -> 戦士のパラメータ
     */
    public Fighter(){
        super(Job.FIGHTER.getId());

        jobName = Job.FIGHTER.getName();
        abilityRange = new AbilityRange(JobParameter.FIGHTER_PARAMETTER);
    }
}