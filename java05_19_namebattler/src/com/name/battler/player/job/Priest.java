package com.name.battler.player.job;

import com.name.battler.player.AbilityRange;
import com.name.battler.player.Player;
import com.name.battler.player.action.Heel;
import com.name.battler.player.action.Palize;
import com.name.battler.player.action.Poison;
import com.name.battler.player.enumplayer.*;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 僧侶
 */
public class Priest extends Player implements Heel, Palize, Poison {
    
    /**
     * コンストラクタ
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
     * 相手を毒状態にする
     */
    @Override
    public void doPoisonState(Player player) {
        player.setCondition(EnumCondition.POISON);
    }

    /**
     * 相手を麻痺状態にする
     */
    @Override
    public void doPalizeState(Player player) {
        if(super.canActionDecreaseMp(EnumAction.HEEL.getCost())){
            player.setCondition(EnumCondition.PALIZE);
        } else {

        }
    }

    /**
     * ヒールを唱える
     */
    @Override
    public void doHeel() {
        if(super.canActionDecreaseMp(EnumAction.HEEL.getCost())){
            this.decreaseHp(EnumAction.HEEL.getDamageRange().getRandomValue());

            System.out.printf(EnumText.HEEL_TEXT01.getText(), this.getName(), this.getHp());
        } else {
            System.out.printf(EnumText.MAGIC_TEXT02.getText());
        }
    }

    /**
     * 僧侶の技を追加
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
