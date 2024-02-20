package com.name.battler.magic;

import com.name.battler.player.IPlayer;

public class Fire extends BaseMagic {

    @Override
    public void effect(IPlayer attacker, IPlayer defender) {

        super.effect(attacker, defender);

        String mess = String.format("ファイヤー！");
        System.out.println(mess);

        mess = String.format("%s は %d のダメージを受けた.", defender.tellName(), this.magicType.power());
        System.out.println(mess);

        defender.damage(this.magicType.power());
    }

    @Override
    public void initMagic() {
        this.magicType = MagicType.FIRE;
    }

}
