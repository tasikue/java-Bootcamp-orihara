package com.name.battler.setting.battle.strategy;

import java.util.List;
import com.name.battler.player.Player;

public interface Strategy {
    public abstract Player getTargetPlayer(List<Player> playerList);
    public abstract int getActionId(Player player);
}
