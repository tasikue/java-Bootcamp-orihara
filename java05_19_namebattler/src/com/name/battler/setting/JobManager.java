package com.name.battler.setting;

import java.util.List;
import java.util.ArrayList;

import com.name.battler.player.Fighter;
import com.name.battler.player.Player;
import com.name.battler.player.Priest;
import com.name.battler.player.Wizard;

public class JobManager {
    
    List<Player> jobList = new ArrayList<>();

    JobManager(){

        jobList.add(new Fighter());
        jobList.add(new Wizard());
        jobList.add(new Priest());
    }
}
