package com.name.battler.player;

import com.name.battler.magic.Fire;
import com.name.battler.magic.Heal;
import com.name.battler.magic.Healable;
import com.name.battler.magic.Magicable;


/**
 * 僧侶クラス
 */
public class Priest extends BasePlayer implements Magicable, Healable {

    // 今回の攻撃が魔法であるか？
    boolean isSelectMagicNotAttack = false;

    public Priest() {
        super();
        initMagics();
    }

    @Override
    public void initJob() {
        job = Job.PRIEST;
    }

    @Override
    public void initMagics() {
        magics.add(new Fire());
        magics.add(new Heal());
    }
}
