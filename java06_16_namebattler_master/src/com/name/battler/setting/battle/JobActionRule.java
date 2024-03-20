package com.name.battler.setting.battle;

import java.util.Random;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumJob;

/**
 * 各ジョブの行動指針を決めるクラス
 */
public class JobActionRule {

    private Random ran = new Random();

    /** 技の数の最大値 */
    final int ACTION_COUNT_MAX = 4;

    /* --- メソッド --- */
    private int selectActionRandom(){

        return ran.nextInt(ACTION_COUNT_MAX);
    }

    public int selectJobAction(Player player){

        // 魔法使いはMPがあるとき呪文優先 
        if(player.getJobId() == EnumJob.WIZARD.getId()){
            if(player.getMp() >= EnumAction.THUNDER.getCost()){
                // random 1-2
                return ran.nextInt(2)+1;
            }
        }


        // 僧侶はダメージがあると回復優先
        if(player.getJobId() == EnumJob.PRIEST.getId()){
            if(player.getHp() <= -(EnumAction.HEEL.getDamageRange().getRandomValue())){
                // 僧侶の回復行動3
                return 3;
            }
        }

        return selectActionRandom();
    }
}
