package com.name.battler.magic;

import com.name.battler.player.IPlayer;

public interface IMagic {

    void initMagic();

    void effect(IPlayer attacker, IPlayer defender);

    boolean canUse(int mp);

    boolean hasEnoughMp(int mp);
}
