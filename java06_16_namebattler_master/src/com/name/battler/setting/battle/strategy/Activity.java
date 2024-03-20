package com.name.battler.setting.battle.strategy;

import java.util.List;

import com.name.battler.player.Player;

/**
 * 戦略を受け止め行動するクラス
 */
public class Activity {
    
    // 変数
    private Strategy strategy;

    /**
     * コンストラクタ
     * @param strategy
     */
    public Activity(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 戦略から今回の標的となるプレイヤーを取得する
     * @return
     */
    public Player getTargetPlayer(List<Player> targetPlayerList){
        return strategy.getTargetPlayer(targetPlayerList);
    }

    /**
     * 戦略から今回繰り出す技番号を取得する
     * @return
     */
    public int getActionId(Player player){
        return strategy.getActionId(player);
    }
}
