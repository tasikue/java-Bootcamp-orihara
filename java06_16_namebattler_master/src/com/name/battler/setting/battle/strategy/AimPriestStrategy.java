package com.name.battler.setting.battle.strategy;

import java.util.List;
import java.util.Random;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumJob;
import com.name.battler.setting.battle.JobActionRule;

/**
 * 僧侶がいたら僧侶を優先して狙う
 */
public class AimPriestStrategy implements Strategy {

    // 変数
    private Random random = new Random();

    @Override
    public Player getTargetPlayer(List<Player> playerList){
        // 相手の選択: 僧侶を探す
        for(Player player: playerList){
            if(player.getJobId() == EnumJob.PRIEST.getId()){
                return player;
            }
        }

        // いなかったら適当に
        return playerList.get(random.nextInt(playerList.size()));
    }
    
    @Override
    public int getActionId(Player player){
        // 個々の行動を優先
        JobActionRule jar = new JobActionRule();
        return jar.selectJobAction(player);
    }
}
