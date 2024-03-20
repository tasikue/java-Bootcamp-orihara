package com.name.battler.player.job;

import com.name.battler.player.Player;
import com.name.battler.player.action.Heel;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumJob;
import com.name.battler.player.enumplayer.EnumJobParameter;
import com.name.battler.setting.AbilityRange;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 勇者
 */
public class Hero extends Player implements Heel{

    // 定数
    /** 行動パターン番号 */
    private final int ACTION_ONE = 1;
    
    /**
     * 職業の勇者を設定するコンストラクタ
     * 
     * ジョブID -> 3
     * ジョブ名 -> 勇者
     * ジョブパラメータ -> 勇者のパラメータ
     */
    public Hero(){
        super(EnumJob.HERO.getId());

        jobName = EnumJob.HERO.getName();
        abilityRange = new AbilityRange(EnumJobParameter.HERO_PARAMETTER);
    }

    /**
     * ヒールを唱える処理
     */
    @Override
    public void doHeel() {
        int cost = EnumAction.HEEL.getCost();

        // 魔法が使えるかの判定
        if(super.pj.canUseMagic(this, cost)){
            // MPを消費
            super.decreaseMp(cost);
            this.decreaseHp(EnumAction.HEEL.getDamageRange().getRandomValue());

            System.out.printf(EnumText.HEEL_TEXT01.getText(), this.getLongName(), this.getHp());
        } else {
            // 使えなかった時のテキスト
            System.out.printf(EnumText.MAGIC_TEXT02.getText());
        }
    }

    /**
     * 勇者の技を実装する処理
     * 0(それ以外) => playerクラスの通常攻撃を実行
     * 1 -> 自身を回復する魔法を実行
     */
    @Override
    public int selectAttack(int attackId, Player player){
        switch (attackId) {
            case ACTION_ONE:
                System.out.printf(
                    EnumText.MAGIC_TEXT01.getText(), 
                    this.getLongName(), 
                    EnumAction.HEEL.getName());
                
                // 実行
                this.doHeel();
            return 0;
        }

        return super.selectAttack(attackId, player);
    }
}
