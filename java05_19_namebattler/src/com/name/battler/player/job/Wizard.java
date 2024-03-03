package com.name.battler.player.job;

import java.util.Random;

import com.name.battler.player.AbilityRange;
import com.name.battler.player.Player;
import com.name.battler.player.action.Fire;
import com.name.battler.player.action.Thunder;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 魔法使い
 * job id: 1
 */
public class Wizard extends Player implements Fire, Thunder {

    final static int JOB_ID = 1;

    // 技ID
    final int FIRE_ID = 1;
    final int THUNDER_ID = 2;

    // 技の固定値
    final int FIRE_MP_COST = 10;
    final int FIRE_DAMAGE_MAX = 30;
    final int FIRE_DAMAGE_MIN = 10;
    final int THUNDER_MP_COST = 20;
    final int THUNDER_DAMAGE_MAX = 30;
    final int THUNDER_DAMAGE_MIN = 10;

    Random ran = new Random();

    // コンストラクタ
    public Wizard(){
        super(JOB_ID);
        jobName = "魔法使い";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(
                        150,
                        50,
                        80,
                        30,
                        50,
                        1,
                        50,
                        1,
                        100,
                        1,
                        60,
                        20
                    );
    }

    /**
     * サンダー
     */
    @Override
    public int doThunderAttack() {
        // MP消費
        super.canActionDecreaseMp(THUNDER_MP_COST);
        // ダメージ値をランダムで返す
        return ran.nextInt(THUNDER_DAMAGE_MAX - THUNDER_DAMAGE_MIN) + THUNDER_DAMAGE_MIN;
    }

    /**
     * ファイヤー
     */
    @Override
    public int doFireAttack() {
        // MP消費
        super.canActionDecreaseMp(FIRE_MP_COST);
        // ダメージ値をランダムで返す
        return ran.nextInt(FIRE_DAMAGE_MAX - FIRE_DAMAGE_MIN) + FIRE_DAMAGE_MIN;
    }

    /**
     * 魔法使いの技を追加
     */
    @Override
    public int selectAttack(int attackId, Player player){
        int damage;

        switch (attackId) {
            // ファイヤーの技
            case FIRE_ID:
            damage = doThunderAttack();

            // ダメージテキスト
            System.out.printf(EnumText.MAGIC_TEXT.getText(), this.getName(), EnumAction.FIRE.getActionName());
            System.out.printf(EnumText.BATTLE_ATTACK_TEXT02.getText(), player.getName(), damage); 

            return damage;

            // サンダーの技
            case THUNDER_ID:
            damage = doFireAttack();

            // ダメージテキスト
            System.out.printf(EnumText.MAGIC_TEXT.getText(), this.getName(), EnumAction.THUNDER.getActionName());
            System.out.printf(EnumText.BATTLE_ATTACK_TEXT02.getText(), player.getName(), damage); 

            return damage;
        }

        return super.selectAttack(attackId, player);
    }
}
