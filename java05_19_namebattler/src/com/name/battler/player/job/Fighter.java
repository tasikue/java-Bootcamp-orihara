package com.name.battler.player.job;

import com.name.battler.player.AbilityRange;
import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumJob;
import com.name.battler.player.enumplayer.EnumJobParameter;

/**
 * 職業: 戦士クラス
 */
public class Fighter extends Player{

    /**
     * コンストラクタ
     * 
     * ジョブID -> 0
     * ジョブ名 -> 戦士
     * ジョブパラメータ -> 戦士のパラメータ
     */
    public Fighter(){
        super(EnumJob.FIGHTER.getId());

        jobName = EnumJob.FIGHTER.getName();
        abilityRange = new AbilityRange(EnumJobParameter.FIGHTER_PARAMETTER);
    }
}