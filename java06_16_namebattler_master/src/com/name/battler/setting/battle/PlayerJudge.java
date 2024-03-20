package com.name.battler.setting.battle;

import java.util.Random;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumCondition;

/**
 * プレイヤーの判定に関するあれこれクラス
 * 
 */
public class PlayerJudge {

    // 定数
    final int RANDOM_MAX = 100;

    /**
     * 列挙型のEnumConditionクラスにより状態異常名を取得する処理
     * @param condition 列挙型の状態異常
     * @return 状態異常名
     */
    public String getCondition(EnumCondition condition){
        switch(condition){
            // 毒状態
            case POISON: 
                return EnumCondition.POISON.getName();

            // 麻痺状態
            case PALIZE:
                return EnumCondition.PALIZE.getName();

            // 通常状態
            default:
                return EnumCondition.NORMAL.getName();
        }
    }

    /**
     * 会心の一撃かどうかを判定する処理
     * @param luck 幸運度
     * @return 会心の一撃か
     */
    public boolean isCritical(int luck){
        Random ran = new Random();

        return luck - ran.nextInt(RANDOM_MAX)+1 > 0;
    }

    /**
     * MPを消費して魔法が使えるかどうか
     * @return 魔法が使えるか
     */
    public boolean canUseMagic(Player player, int cost){
        if (player.getMp() >= cost){
            return true;
        }
        return false;
    }

    /**
     * プレイヤーのHPを見て死亡判定
     * @return 死んだかどうか
     */
    public boolean isDead(Player player){
        return player.getHp() <= 0;
    }
}