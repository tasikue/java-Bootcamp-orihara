package com.name.battler.player.job;

import com.name.battler.player.Player;
import com.name.battler.player.action.Heel;
import com.name.battler.player.action.Palize;
import com.name.battler.player.action.Poison;
import com.name.battler.player.enumplayer.*;
import com.name.battler.setting.AbilityRange;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 僧侶
 */
public class Priest extends Player implements Heel, Palize, Poison {
    
    /**
     * 職業の僧侶を設定するコンストラクタ
     * 
     * ジョブID -> 2
     * ジョブ名 -> 僧侶
     * ジョブパラメータ -> 僧侶のパラメータ
     */
    public Priest(){
        super(EnumJob.PRIEST.getId());

        jobName = EnumJob.PRIEST.getName();
        abilityRange = new AbilityRange(EnumJobParameter.PRIEST_PARAMETTER);
    }

    /* --- メソッド --- */
    /**
     * 相手を毒状態にする処理
     */
    @Override
    public void doPoisonState(Player player) {
        int cost = EnumAction.POISON.getCost();

        // 魔法が使えるかの判定
        if(super.pj.canUseMagic(this, cost)){
            // MPを消費
            super.decreaseMp(cost);
            player.setCondition(EnumCondition.POISON);
        } else {
            // 使えなかったときのテキスト
            System.out.printf(EnumText.MAGIC_TEXT02.getText());
        }
    }

    /**
     * 相手を麻痺状態にする処理
     */
    @Override
    public void doPalizeState(Player player) {
        int cost = EnumAction.PALIZE.getCost();

        // 魔法が使えるかの判定
        if(super.pj.canUseMagic(this, cost)){
            // MPを消費
            super.decreaseMp(cost);
            player.setCondition(EnumCondition.PALIZE);
        } else {
            // 使えなかった時のテキスト
            System.out.printf(EnumText.MAGIC_TEXT02.getText());
        }
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

            System.out.printf(EnumText.HEEL_TEXT01.getText(), this.getName(), this.getHp());
        } else {
            // 使えなかった時のテキスト
            System.out.printf(EnumText.MAGIC_TEXT02.getText());
        }
    }

    /**
     * 僧侶の技を実装する処理
     * 0(それ以外) => playerクラスの通常攻撃を実行
     * 1 -> 相手を毒にする魔法を実行
     * 2 -> 相手を麻痺にする魔法を実行
     * 3 -> 自身を回復する魔法を実行
     */
    @Override
    public int selectAttack(int attackId, Player player){
        switch (attackId) {
            case 1:
                System.out.printf(
                    EnumText.MAGIC_TEXT01.getText(),
                    this.getName(),
                    EnumAction.POISON.getName());
                
                // 実行
                this.doPoisonState(player);
            return 0;

            case 2:
                System.out.printf(
                    EnumText.MAGIC_TEXT01.getText(), 
                    this.getName(), 
                    EnumAction.PALIZE.getName());
                
                // 実行
                this.doPalizeState(player);
            return 0;
            
            case 3:
                System.out.printf(
                    EnumText.MAGIC_TEXT01.getText(), 
                    this.getName(), 
                    EnumAction.HEEL.getName());
                
                // 実行
                this.doHeel();
            return 0;
        }

        return super.selectAttack(attackId, player);
    }
}