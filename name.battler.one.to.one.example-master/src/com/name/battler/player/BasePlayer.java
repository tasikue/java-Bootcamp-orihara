package com.name.battler.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.name.battler.magic.Healable;
import com.name.battler.magic.IMagic;
import com.name.battler.magic.Magicable;

public abstract class BasePlayer implements IPlayer {

    List<IMagic> magics;

    protected Job job;

    protected int hp;
    protected int mp;
    protected int str;

    private String name;

    public BasePlayer() {

        magics = new ArrayList<>();

        this.initJob();

        this.hp = job.hp();
        this.mp = job.mp();
        this.str = job.str();
    }

    @Override
    public void attackTo(IPlayer defender) {

        boolean isDoneMagic = this.magicAttack(defender);
        if (isDoneMagic) return;

        this.normalAttack(defender);
    }

    @Override
    public void normalAttack(IPlayer defender) {

        String mess = String.format("%s が %s を叩いた.", this.tellName(), defender.tellName());
        System.out.println(mess);

        mess = String.format("%s が %s のダメージを受けた.", defender.tellName(), this.str);
        System.out.println(mess);

        this.damagedTo(defender, this.str);
    }

    @Override
    public boolean magicAttack(IPlayer defender) {

        IMagic magic = null;
        boolean isDoneMagic = false;

        if (this instanceof Magicable)
            magic = this.choiceMagic();

        if (magic != null) {
            magic.effect(this, defender);
            isDoneMagic = true;
            return isDoneMagic;
        }
        return isDoneMagic;
    }

    @Override
    public void showStatus() {

        String mess = String.format(
                "{ Name: %-10s, %-8s: HP: %3d, MP: %3d, STR: %3d, MagicListSize: %d }", this.name,
                this.job.job(), this.hp, this.mp, this.str, this.magics.size());
        System.out.println(mess);
    }

    @Override
    public void initJob() {
    }

    @Override
    public IMagic choiceMagic() {

        Collections.shuffle(magics);

        for (IMagic magic : magics) {

            if (!magic.canUse(this.mp))
                return null;

            if (this instanceof Healable) {

                if (this.isNotFullHp())
                    return magic;
            }

            return magic;
        }
        return null;
    }

    @Override
    public boolean isNotFullHp() {
        return job.hp() - this.hp > 0;
    }

    @Override
    public String tellName() {
        return this.name;
    }

    @Override
    public IPlayer giveName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public void damagedTo(IPlayer defender, int power) {

        defender.damage(power);
    }

    @Override
    public void damage(int power) {

        this.hp = this.hp - power;

        if (this.hp < 0)
            this.hp = 0;
    }

    @Override
    public void heal(int recoveryPoint) {

        if (this.hp + recoveryPoint > this.job.hp()) {

            this.hp = this.job.hp();
            return;
        }
        this.hp = this.hp + recoveryPoint;
    }

    @Override
    public boolean isLive() {

        return this.hp > 0;
    }

    @Override
    public void downMp(int mp) {

        this.mp = this.mp - mp;
    }

    public int getHp() {
        return this.hp;
    }
}
