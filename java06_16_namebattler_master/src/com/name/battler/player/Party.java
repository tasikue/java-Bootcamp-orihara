package com.name.battler.player;

import java.util.ArrayList;
import java.util.List;

/**
 * パーティクラス
 */
public class Party {

    // 定数
    /** 最大パーティ数 */
    private final static int PARTY_MEMBER_COUNT = 3;
    
    /** プレイヤーをリストで保持 */
    private List<Player> members;
    /** パーティの作戦 */
    private int currentStrategy;

    /**
     * コンストラクタ
     */
    public Party(int currentStrategy) {
        members = new ArrayList<>();
        this.currentStrategy = currentStrategy;
    }

    /**
     * パーティのメンバー一覧
     * @return メンバーのリスト
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
        // 所属したプレイヤーにこのパーティナンバーを設定する
        player.setPartyNumber(partyNumber);
    }
    
    /**
     * パーティーからプレイヤーを離脱させる
     * @param player 離脱させるプレイヤー
     */
    public void removePlayer(Player player) {
        members.remove(player);
    }

    /**
     * パーティが全滅したか
     * @return パーティが全滅しかたどうか
     */
    public boolean isPartyAnnihilation(){
        return this.getMembers().size() <= 0;
    }

    /**
     * パーティの最大数を取得する処理
     * @return パーティの最大人数
     */
    public static int getMaxPartyCount(){
        return PARTY_MEMBER_COUNT;
    }

    /**
     * 今回の作戦ナンバーを取得する処理
     */
    public int getCurrendStrategy(){
        return currentStrategy;
    }
}