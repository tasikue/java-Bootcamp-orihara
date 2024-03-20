package com.name.battler.setting.battle.strategy;

import java.util.List;
import java.util.Random;

import com.name.battler.player.Player;
import com.name.battler.setting.battle.JobActionRule;

/**
 * ランダムで攻撃対象を決める
 */
public class RandomStrategy implements Strategy {

    // 変数
    private Random random = new Random();

    @Override
    public Player getTargetPlayer(List<Player> playerList){
        // 相手の選択: 攻撃対象リストからランダムで選択
        return playerList.get(random.nextInt(playerList.size()));
    }
    
    @Override
    public int getActionId(Player player){
        // 個々の行動を優先
        JobActionRule jar = new JobActionRule();
        return jar.selectJobAction(player);
    }
}
