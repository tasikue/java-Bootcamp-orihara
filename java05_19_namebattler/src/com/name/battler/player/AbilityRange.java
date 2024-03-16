package com.name.battler.player;

import com.name.battler.player.enumplayer.EnumJobParameter;

/**
 * 能力範囲を指定するクラス
 */
public class AbilityRange {
        
    // 変数
    private EnumJobParameter jobParameter;

    /**
     * 列挙型のジョブパラメータを入力するコンストラクタ
     * @param jobParameter ジョブパラメータ
     */
    public AbilityRange(EnumJobParameter jobParameter){
        this.jobParameter = jobParameter;
    }

    /**
     * ジョブパラメータを出力する処理
     * @return ジョブパラメータ
     */
    public EnumJobParameter getJobParameter(){
        return jobParameter;
    }
}