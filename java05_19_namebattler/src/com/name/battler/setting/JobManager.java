package com.name.battler.setting;

import java.util.List;
import java.util.ArrayList;

import com.name.battler.player.Fighter;
import com.name.battler.player.Player;
import com.name.battler.player.Priest;
import com.name.battler.player.Wizard;

/**
 * ジョブを管理するクラス
 */
public class JobManager {
    
    // ジョブを収納するクラス
    List<Player> jobList = new ArrayList<>();

    JobManager(){
        // ジョブを設定
        jobList.add(new Fighter());
        jobList.add(new Wizard());
        jobList.add(new Priest());
    }

    /**
     * ジョブIDからジョブを得る
     * @param jobId ジョブID
     * @return ジョブ
     */
    public Player getJob(int jobId){
        return jobList.get(jobId);
    }
}
