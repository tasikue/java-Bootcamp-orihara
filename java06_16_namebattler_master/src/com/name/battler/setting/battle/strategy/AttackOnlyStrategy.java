package com.name.battler.setting.battle.strategy;

import java.util.List;
import java.util.Random;

import com.name.battler.player.Player;

/**
 * 通常攻撃しかしない
 */
public class AttackOnlyStrategy implements Strategy {

    // 定数
    final int NORMAL_ATTACK_ID = 0;

    // 変数
    private Random random = new Random();

    @Override
    public Player getTargetPlayer(List<Player> playerList){
        // 相手の選択: 攻撃対象リストからランダムで選択
        return playerList.get(random.nextInt(playerList.size()));
    }
    
    @Override
    public int getActionId(Player player){
        // 0 はどのジョブも通常攻撃を行う
        return NORMAL_ATTACK_ID;
    }
}
