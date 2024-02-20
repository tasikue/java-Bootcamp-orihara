package com.name.battler.magic;

import com.name.battler.player.IPlayer;

public class Heal extends BaseMagic {

    @Override
    public void effect(IPlayer attacker, IPlayer defender) {

        super.effect(attacker, defender);

        String mess = String.format("ヒール！");
        System.out.println(mess);

        mess = String.format("%s は体力を %d hp 回復した.", attacker.tellName(), this.magicType.recoveryPoint());
        System.out.println(mess);

        attacker.heal(this.magicType.recoveryPoint());
    }

    @Override
    public void initMagic() {
        this.magicType = MagicType.HEAL;
    }
}
