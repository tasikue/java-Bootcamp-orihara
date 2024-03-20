package com.name.battler.setting.battle.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.name.battler.player.Player;
import com.name.battler.setting.battle.JobActionRule;

/**
 * 相手のチームのHPが低いやつを狙う
 */
public class AimWeakOpponentStrategy implements Strategy {

    @Override
    public Player getTargetPlayer(List<Player> playerList){
        // 相手の選択: HPが低いやつを探す

        // HPが低い順でソート
        Comparator<Player> hpComparator = new Comparator<Player>(){
             @Override
             public int compare(Player player1, Player player2){
                 return player1.getHp() - player2.getHp();
            }
        };
        Collections.sort(playerList, hpComparator);

        // リストの先頭を渡す
        return playerList.get(0);
    }
    
    @Override
    public int getActionId(Player player){
        // 個々の行動を優先
        JobActionRule jar = new JobActionRule();
        return jar.selectJobAction(player);
    }
}
