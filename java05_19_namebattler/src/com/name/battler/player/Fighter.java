package com.name.battler.player;

public class Fighter extends Player{
    
    // 変数
    
    // コンストラクタ
    public Fighter(int jobId){
        super(jobId);
    }
    
    /**
     * @return jobId
     */
    public int getJobId(){
        return super.jobId;
    }

    @Override
    public void doNormalAttack() {
    }
}
