package com.name.battler.setting;

import com.name.battler.player.Fighter;

/**
 * 名前を受け取ってキャラクターを作成するクラス
 */
public class PlayerMaking {

    HashDigest hash = new HashDigest();


    
    // コンストラクタ
    public PlayerMaking(String name){

        for(int i=0; i<20; i++){
            System.out.println(hash.generateNumber(name, i));
        }

        Fighter fighter = new Fighter(1);

        fighter.setHp(hash.generateNumber(name, 0));
        fighter.setMp(hash.generateNumber(name, 1));
        fighter.setStr(hash.generateNumber(name, 2));
        fighter.setDef(hash.generateNumber(name, 3));
        fighter.setLuck(hash.generateNumber(name, 4));
        fighter.setAgi(hash.generateNumber(name, 5));

        // System.out.println(fighter.getClass());
        fighter.showAllStatus();
    }

    public static void main(String[] args) {
        PlayerMaking pm = new PlayerMaking("null");

    }
}
