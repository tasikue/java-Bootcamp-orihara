package com.name.battler.player;

public class Wizard extends Player{

    // 変数

    // コンストラクタ
    public Wizard(int jobId){
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doNormalAttack'");
    }
}
