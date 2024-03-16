package com.name.battler.setting;

import java.util.List;
import java.util.ArrayList;

import com.name.battler.player.Player;
import com.name.battler.player.job.Fighter;
import com.name.battler.player.job.Priest;
import com.name.battler.player.job.Wizard;

/**
 * ジョブを管理するクラス
 */
public class JobManager {
    
    // ジョブを収納するクラス
    List<Player> jobList = new ArrayList<>();

    public JobManager(){
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

    public List<Player> getJobList(){
        return jobList;
    }
}
