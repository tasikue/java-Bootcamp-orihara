package com.name.battler.setting;

import com.name.battler.player.Fighter;
import com.name.battler.player.Priest;
import com.name.battler.player.Wizard;

/**
 * ジョブを管理するクラス
 */
public class JobManager {

    // すべての職業クラスをインスタンス化
    Fighter fighter = new Fighter(1);
    Wizard wizard = new Wizard(2);
    Priest priest = new Priest(3);
}
