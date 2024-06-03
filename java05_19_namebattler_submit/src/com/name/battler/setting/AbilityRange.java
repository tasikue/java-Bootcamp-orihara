package com.name.battler.setting;

import com.name.battler.player.job.JobParameter;

/**
 * 能力範囲を指定するクラス
 */
public class AbilityRange {
        
    // 変数
    private JobParameter jobParameter;

    /**
     * 列挙型のジョブパラメータを入力するコンストラクタ
     * @param jobParameter ジョブパラメータ
     */
    public AbilityRange(JobParameter jobParameter){
        this.jobParameter = jobParameter;
    }

    /**
     * ジョブパラメータを出力する処理
     * @return ジョブパラメータ
     */
    public JobParameter getJobParameter(){
        return jobParameter;
    }
}