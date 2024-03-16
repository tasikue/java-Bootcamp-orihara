package com.name.battler.setting;

import java.util.List;
import java.util.ArrayList;

import com.name.battler.player.Player;
import com.name.battler.player.job.Fighter;
import com.name.battler.player.job.Hero;
import com.name.battler.player.job.Priest;
import com.name.battler.player.job.Wizard;

/**
 * ジョブを管理するクラス
 */
public class JobManager {
    
    // ジョブを収納するクラス
    private List<Player> jobList = new ArrayList<>();

    public JobManager(){
        // ジョブを設定
        jobList.add(new Fighter());
        jobList.add(new Wizard());
        jobList.add(new Priest());
        jobList.add(new Hero());
    }

    /**
     * ジョブIDからジョブを取得する処理
     * @param jobId ジョブID
     * @return ジョブ
     */
    public Player getJob(int jobId){
        return jobList.get(jobId);
    }

    /**
     * 全ジョブリストを取得する処理
     * @return 全ジョブ
     */
    public List<Player> getJobList(){
        return jobList;
    }
}
