package com.name.battler.party;

import java.util.ArrayList;
import java.util.List;

import com.name.battler.player.Player;

/**
 * パーティクラス
 */
public class Party {
    
    /** プレイヤーをリストで保持 */
    private List<Player> members;

    /**
     * コンストラクタ
     */
    public Party() {
        members = new ArrayList<>();
    }

    /**
     * パーティのメンバー一覧
     * @return
     */
    public List<Player> getMembers() {
        return members;
    }

    /**
     * パーティーにプレイヤーを追加する
     * @param player 追加するプレイヤー
     * @param partyNumber 所属するパーティナンバー
     */
    public void appendPlayer(Player player, int partyNumber) {
        members.add(player);
        player.setPartyNumber(partyNumber);
    }
    
    /**
     * パーティーからプレイヤーを離脱させる
     * @param player 離脱させるプレイヤー
     */
    public void removePlayer(Player player) {
        members.remove(player);
    }
}