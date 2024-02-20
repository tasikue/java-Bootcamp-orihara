package com.name.battler.player;

import com.name.battler.magic.IMagic;

public interface IPlayer {

    void attackTo(IPlayer defender);
    void normalAttack(IPlayer defender);
    boolean magicAttack(IPlayer defender);

    void showStatus();

    void initJob();

    IMagic choiceMagic();

    IPlayer giveName(String name);

    String tellName();

    void damagedTo(IPlayer defender, int power);
    void damage(int power);

    void heal(int recoveryPoint);

    boolean isLive();

    boolean isNotFullHp();

    void downMp(int mp);

    int getHp();
}
