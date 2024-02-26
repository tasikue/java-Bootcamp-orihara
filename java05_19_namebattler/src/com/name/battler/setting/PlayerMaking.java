package com.name.battler.setting;

import com.name.battler.player.Fighter;
import com.name.battler.player.Priest;
import com.name.battler.player.Wizard;

/**
 * 名前を受け取ってキャラクターを作成するクラス
 * 
 */
public class PlayerMaking {

    // 定数
    final int JOB_COUNT = 3;

    final int HASH_MIN = 0;
    final int HASH_MAX = 256;

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
    Fighter fighter;
    Wizard wizard;
    Priest priest;

    
    // コンストラクタ
    public PlayerMaking(String name){

        // 職業の選択
        jobId = getAbilityValue(name, HASH_INDEX_ZERO, JOB_COUNT, 0);
        setJob(name, jobId);
    }

    /**
     * ハッシュで得た0-255を上限下限で丸める
     */
    private int getAbilityValue(String name, int index, int maxValue, int minValue){
        return (maxValue - minValue) * hash.generateNumber(name, index) / (HASH_MAX - HASH_MIN);
    }

    /**
     * ジョブに値をセットする
     * @param name プレイヤー名
     * @param jobId ジョブID
     */
    private void setJob(String name, int jobId){
        // ID:0 -> 戦士, ID:1 -> 魔法使い, ID: 2 -> 僧侶;
        switch (jobId) {
            case 0:
                fighter = new Fighter();

                // それぞれの値をセット
                fighter.setHp(getAbilityValue(name, HASH_INDEX_ONE, fighter.getAbilityRange().getHpMax(), fighter.getAbilityRange().getHpMin()));
                fighter.setMp(getAbilityValue(name, HASH_INDEX_TWE, fighter.getAbilityRange().getMpMax(), fighter.getAbilityRange().getMpMin()));
                fighter.setStr(getAbilityValue(name, HASH_INDEX_THREE, fighter.getAbilityRange().getStrMax(), fighter.getAbilityRange().getStrMin()));
                fighter.setDef(getAbilityValue(name, HASH_INDEX_FOUR, fighter.getAbilityRange().getDefMax(), fighter.getAbilityRange().getDefMin()));
                fighter.setLuck(getAbilityValue(name, HASH_INDEX_FIVE, fighter.getAbilityRange().getLuckMax(), fighter.getAbilityRange().getLuckMin()));
                fighter.setAgi(getAbilityValue(name, HASH_INDEX_SIX, fighter.getAbilityRange().getAgiMax(), fighter.getAbilityRange().getAgiMin()));
                break;
        
                case 1:
                wizard = new Wizard();

                // それぞれの値をセット
                wizard.setHp(getAbilityValue(name, HASH_INDEX_ONE, wizard.getAbilityRange().getHpMax(), wizard.getAbilityRange().getHpMin()));
                wizard.setMp(getAbilityValue(name, HASH_INDEX_TWE, wizard.getAbilityRange().getMpMax(), wizard.getAbilityRange().getMpMin()));
                wizard.setStr(getAbilityValue(name, HASH_INDEX_THREE, wizard.getAbilityRange().getStrMax(), wizard.getAbilityRange().getStrMin()));
                wizard.setDef(getAbilityValue(name, HASH_INDEX_FOUR, wizard.getAbilityRange().getDefMax(), wizard.getAbilityRange().getDefMin()));
                wizard.setLuck(getAbilityValue(name, HASH_INDEX_FIVE, wizard.getAbilityRange().getLuckMax(), wizard.getAbilityRange().getLuckMin()));
                wizard.setAgi(getAbilityValue(name, HASH_INDEX_SIX, wizard.getAbilityRange().getAgiMax(), wizard.getAbilityRange().getAgiMin()));
                break;

                case 2:
                priest = new Priest();

                // それぞれの値をセット
                priest.setHp(getAbilityValue(name, HASH_INDEX_ONE, priest.getAbilityRange().getHpMax(), priest.getAbilityRange().getHpMin()));
                priest.setMp(getAbilityValue(name, HASH_INDEX_TWE, priest.getAbilityRange().getMpMax(), priest.getAbilityRange().getMpMin()));
                priest.setStr(getAbilityValue(name, HASH_INDEX_THREE, priest.getAbilityRange().getStrMax(), priest.getAbilityRange().getStrMin()));
                priest.setDef(getAbilityValue(name, HASH_INDEX_FOUR, priest.getAbilityRange().getDefMax(), priest.getAbilityRange().getDefMin()));
                priest.setLuck(getAbilityValue(name, HASH_INDEX_FIVE, priest.getAbilityRange().getLuckMax(), priest.getAbilityRange().getLuckMin()));
                priest.setAgi(getAbilityValue(name, HASH_INDEX_SIX, priest.getAbilityRange().getAgiMax(), priest.getAbilityRange().getAgiMin()));
                break;

            default:
                break;
        }
    }

    /**
     * ハッシュ値から選ばれはジョブIDを返す
     * @return ジョブID
     */
    public int getJobId(){
        return this.jobId;
    }

    public static void main(String[] args) {
        PlayerMaking pm = new PlayerMaking("null");
        System.out.println("jobid: " + pm.getJobId());

        System.out.println(pm.fighter.getHp());
    }
}
