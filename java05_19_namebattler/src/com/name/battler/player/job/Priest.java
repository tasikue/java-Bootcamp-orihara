package com.name.battler.player.job;

import com.name.battler.player.AbilityRange;
import com.name.battler.player.Player;
import com.name.battler.player.action.Heel;
import com.name.battler.player.action.Palize;
import com.name.battler.player.action.Poison;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.statustext.EnumText;

/**
 * 職業: 僧侶
 * job id: 2 
 */
public class Priest extends Player implements Heel, Palize, Poison {

    final static int JOB_ID = 2;

    // 技ID
    final int POSION_ID = 1;
    final int PALIZE_ID = 2;
    final int HEEL_ID = 3;

    // 技の固定値
    final int HEEL_MP_COST = 20;
    final int HEEL_RECOVERY_QUANTITY = -50;
    
    public Priest(){
        super(JOB_ID);
        jobName = "僧侶";

        // 職業別パラメータ（固定値）
        abilityRange = new AbilityRange(
                        200, 
                        80, 
                        50, 
                        20, 
                        70, 
                        10, 
                        70, 
                        10, 
                        100, 
                        1, 
                        60, 
                        20
                    );
    }

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
        player.setCondition(EnumCondition.PALIZE);
    }

    /**
     * ヒールを唱える
     */
    @Override
    public void doHeel() {
        if(super.canActionDecreaseMp(HEEL_MP_COST)){
            this.decreaseHp(HEEL_RECOVERY_QUANTITY);

            System.out.printf(EnumText.HEEL_TEXT02.getText(), this.getName(), this.getHp());
        } else {
            System.out.printf(EnumText.HEEL_TEXT03.getText());
        }
    }

    /**
     * 僧侶の技を追加
     */
    @Override
    public int selectAttack(int attackId, Player player){
        switch (attackId) {
            // 相手を毒にする
            case POSION_ID:
                // テキスト
                System.out.printf(EnumText.MAGIC_TEXT.getText(), this.getName(), EnumAction.POISON.getActionName());
                // 実行
                this.doPoisonState(player);
            return 0;

            // 相手を麻痺にする
            case PALIZE_ID:
                // テキスト
                System.out.printf(EnumText.MAGIC_TEXT.getText(), this.getName(), EnumAction.PALIZE.getActionName());
                // 実行
                this.doPalizeState(player);
            return 0;
            
            // 自身を回復する
            case HEEL_ID:
                // テキスト
                System.out.printf(EnumText.MAGIC_TEXT.getText(), this.getName(), EnumAction.HEEL.getActionName());
                // 実行
                this.doHeel();
            return 0;
        }

        return super.selectAttack(attackId, player);
    }
    
}
