package com.name.battler.setting;

import com.name.battler.player.Player;

/**
 * 名前を受け取ってキャラクターを作成するクラス
 * 
 */
public class PlayerMaking {

    // 定数
    final int JOB_COUNT = 3;

    final int HASH_MIN = 0;
    final int HASH_MAX = 256;

    // x番目のハッシュ値のインデックス
    final int HASH_INDEX_ZERO = 0;
    final int HASH_INDEX_ONE = 1;
    final int HASH_INDEX_TWE = 2;
    final int HASH_INDEX_THREE = 3;
    final int HASH_INDEX_FOUR = 4;
    final int HASH_INDEX_FIVE = 5;
    final int HASH_INDEX_SIX = 6;

    HashDigest hash = new HashDigest();

    // 変数
    int jobId;
    Player player;
    
    // コンストラクタ
    public PlayerMaking(String name, int jobId){
        player = setJob(name, jobId);
    }

    /**
     * ハッシュで得た0-256を上限下限で丸める
     */
    private int getAbilityValue(String name, int index, int maxValue, int minValue){
        return (maxValue - minValue) * hash.generateNumber(name, index) / (HASH_MAX - HASH_MIN) + minValue;
    }

    /**
     * ジョブに値をセットする
     * @param name プレイヤー名
     * @param jobId ジョブID
     */
    private Player setJob(String name, int jobId){
        // jobManager から jobID を渡して jobを得る
        JobManager jobManager = new JobManager();
        player = jobManager.getJob(jobId);

        // 名前・HP・MP・こうげき・ぼうぎょ・こううん・すばやさの値をセット
        player.setPlayerStatus(
            name, 
            getAbilityValue(name, HASH_INDEX_ONE, player.getAbilityRange().getHpMax(), player.getAbilityRange().getHpMin()),
            getAbilityValue(name, HASH_INDEX_TWE, player.getAbilityRange().getMpMax(), player.getAbilityRange().getMpMin()),
            getAbilityValue(name, HASH_INDEX_THREE, player.getAbilityRange().getStrMax(), player.getAbilityRange().getStrMin()),
            getAbilityValue(name, HASH_INDEX_FOUR, player.getAbilityRange().getDefMax(), player.getAbilityRange().getDefMin()),
            getAbilityValue(name, HASH_INDEX_FIVE, player.getAbilityRange().getLuckMax(), player.getAbilityRange().getLuckMin()),
            getAbilityValue(name, HASH_INDEX_SIX, player.getAbilityRange().getAgiMax(), player.getAbilityRange().getAgiMin())
        );

        return player;
    }

    /**
     * ハッシュ値から選ばれはジョブIDを返す
     * @return ジョブID
     */
    /*public int getJobId(){
        return this.jobId;
    }*/
    
    /**
     * ジョブを返す
     * @return ジョブ
     */
    public Player getPlayer(){
        return this.player;
    }
}
