package com.name.battler.magic;

import com.name.battler.player.IPlayer;

public abstract class BaseMagic implements IMagic {

    protected MagicType magicType;

    public BaseMagic() {

        this.initMagic();
    }

    @Override
    public void effect(IPlayer attacker, IPlayer defender) {

        String mess = String.format("%s は %s を唱えた.", attacker.tellName(), this.magicType.getName());
        System.out.println(mess);

        attacker.downMp(this.magicType.mp());
    }

    @Override
    public boolean canUse(int mp) {
        
        if (this.hasEnoughMp(mp)) return true;

        return false;
    }

    public boolean hasEnoughMp(int mp) {
        return this.magicType.mp() <= mp;
    }

    @Override
    public void initMagic() {
    }

}