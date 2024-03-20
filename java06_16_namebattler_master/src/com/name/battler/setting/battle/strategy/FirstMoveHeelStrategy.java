package com.name.battler.setting.battle.strategy;

import java.util.List;
import java.util.Random;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumJob;
import com.name.battler.setting.battle.JobActionRule;
import com.name.battler.setting.battle.PlayerJudge;

/**
 * 僧侶と勇者はとりあえずヒールを連発する
 */
public class FirstMoveHeelStrategy implements Strategy {

    // 定数
    final int HERO_HEEL_ACTION_ID = 1;
    final int PRIEST_HEEL_ACTION_ID = 3;

    // 変数
    private Random random = new Random();
    private PlayerJudge pj = new PlayerJudge();

    @Override
    public Player getTargetPlayer(List<Player> playerList){
        // 相手はランダムで
        return playerList.get(random.nextInt(playerList.size()));
    }
    
    @Override
    public int getActionId(Player player){
        // 勇者のヒール行動
        if(player.getJobId() == EnumJob.HERO.getId()){
            if(pj.canUseMagic(player, EnumAction.HEEL.getCost())){
                return HERO_HEEL_ACTION_ID;
            }
        }

        // 僧侶のヒール行動
        if(player.getJobId() == EnumJob.PRIEST.getId()){
            if(pj.canUseMagic(player, EnumAction.HEEL.getCost())){
                return PRIEST_HEEL_ACTION_ID;
            }
        }

        // そうじゃないなら個々の行動を優先
        JobActionRule jar = new JobActionRule();
        return jar.selectJobAction(player);
    }
}
