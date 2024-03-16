package com.name.battler.player.job;

import com.name.battler.player.Player;
import com.name.battler.player.action.Fire;
import com.name.battler.player.action.Thunder;
import com.name.battler.player.enumplayer.*;
import com.name.battler.setting.AbilityRange;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 魔法使い
 */
public class Wizard extends Player implements Fire, Thunder {

    /**
     * コンストラクタ
     * 
     * ジョブID -> 1
     * ジョブ名 -> 魔法使い
     * ジョブパラメータ -> 魔法使いのパラメータ
     */
    public Wizard(){
        super(EnumJob.WIZARD.getId());

        jobName = EnumJob.WIZARD.getName();
        abilityRange = new AbilityRange(EnumJobParameter.WIZARD_PARAMETTER);
    }

    /**
     * サンダーを唱える処理
     * @return 与えるダメージ
     */
    @Override
    public int doThunderAttack() {
        int cost = EnumAction.THUNDER.getCost();

        // 魔法が使えるかの判定
        if(super.pj.canUseMagic(this, cost)){
            // MPを消費
            super.decreaseMp(cost);
            // ダメージ値をランダムで返す
            return EnumAction.THUNDER.getDamageRange().getRandomValue();
        }

        // 魔法が使えないテキスト
        System.out.printf(EnumText.MAGIC_TEXT02.getText());
        return 0;
    }

    /**
     * ファイヤーを唱える処理
     */
    @Override
    public int doFireAttack() {
        int cost = EnumAction.FIRE.getCost();

        // 魔法が使えるかの判定
        if(super.pj.canUseMagic(this, cost)){
            // MPを消費
            super.decreaseMp(cost);
            // ダメージ値をランダムで返す
            return EnumAction.FIRE.getDamageRange().getRandomValue();
        }

        // 魔法が使えないテキスト
        System.out.printf(EnumText.MAGIC_TEXT02.getText());
        return 0;
    }

    /**
     * 魔法使いの技を実行する処理
     * 0(それ以外) -> layerクラスの通常攻撃を実行
     * 1 -> ファイヤーの技
     * 2 -> サンダーの技
     */
    @Override
    public int selectAttack(int attackId, Player player){
        int damage;

        switch (attackId) {
            case 1:
            damage = doThunderAttack();

            // ダメージテキスト
            Dialogue.showDamageText(this.name, EnumAction.FIRE.getName(), player.getName(), damage);
            return damage;

            case 2:
            damage = doFireAttack();

            // ダメージテキスト
            Dialogue.showDamageText(this.name, EnumAction.THUNDER.getName(), player.getName(), damage);
            return damage;
        }

        return super.selectAttack(attackId, player);
    }
}