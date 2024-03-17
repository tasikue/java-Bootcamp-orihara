package com.name.battler.setting;

import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumJobParameter;

/**
 * 名前を受け取ってキャラクターを作成するクラス
 * 
 */
public class PlayerMaking {

    // 定数
    /** ハッシュの最大最少 */
    final int HASH_MIN = 0;
    final int HASH_MAX = 256;

    /** x番目のハッシュ値のインデックス */
    private final int HASH_INDEX_ZERO = 0;
    private final int HASH_INDEX_ONE = 1;
    private final int HASH_INDEX_TWO = 2;
    private final int HASH_INDEX_THREE = 3;
    private final int HASH_INDEX_FOUR = 4;
    private final int HASH_INDEX_FIVE = 5;

    // 変数
    /** プレイヤークラス */
    private Player player;
    
    /**
     * 名前とジョブIDからプレイヤーを作成するコンストラクタ
     * @param name 作成するプレイヤー名
     * @param jobId 作成するジョブID
     */
    public PlayerMaking(String name, int jobId){
        this.player = setJob(name, jobId);
    }

    /**
     * ハッシュで得た0-256を上限下限で丸める処理
     * @param name 作成するプレイヤー名
     * @param index 使うハッシュのインデックス
     * @param maxValue 能力値の最大値
     * @param minValue 能力値の最小値
     * @return 確定した能力値
     */
    private int getAbilityValue(String name, int index, int minValue, int maxValue){
        // ハッシュ計算用インスタンス
        HashDigest hashDigest = new HashDigest();
        // ハッシュ範囲
        Range hashRange = new Range(HASH_MIN, HASH_MAX);;

        return (maxValue - minValue) * hashDigest.generateNumber(name, index) / (hashRange.getMax() - hashRange.getMin()) + minValue;
    }

    /**
     * プレイヤーを作成する処理
     * @param name 作成するプレイヤー名
     * @param jobId 作成するジョブID
     */
    private Player setJob(String name, int jobId){
        // ジョブIDからジョブを確定する
        JobManager jobManager = new JobManager();
        player = jobManager.getJob(jobId);

        // 名前・HP・MP・こうげき・ぼうぎょ・こううん・すばやさの値をセット
        EnumJobParameter jobParameter = player.getAbilityRange().getJobParameter();
        player.setPlayerStatus(
            name, 
            getAbilityValue(name, HASH_INDEX_ZERO, jobParameter.getHpRange().getMin(), jobParameter.getHpRange().getMax()),
            getAbilityValue(name, HASH_INDEX_ONE, jobParameter.getMpRange().getMin(), jobParameter.getMpRange().getMax()),
            getAbilityValue(name, HASH_INDEX_TWO, jobParameter.getStrRange().getMin(), jobParameter.getStrRange().getMax()),
            getAbilityValue(name, HASH_INDEX_THREE, jobParameter.getDefRange().getMin(), jobParameter.getDefRange().getMax()),
            getAbilityValue(name, HASH_INDEX_FOUR, jobParameter.getLuckRange().getMin(), jobParameter.getLuckRange().getMax()),
            getAbilityValue(name, HASH_INDEX_FIVE, jobParameter.getAgiRange().getMin(), jobParameter.getAgiRange().getMax())
        );

        return player;
    }

    /**
     * 作成したプレイヤーを取得する処理
     * @return プレイヤー
     */
    public Player getPlayer(){
        return this.player;
    }
}
