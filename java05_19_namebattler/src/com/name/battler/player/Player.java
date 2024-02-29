package com.name.battler.player;

import java.util.Random;

import com.name.battler.player.action.Attack;
import com.name.battler.statustext.EnumText;

/**
 * プレイヤーの基底クラス
 */
public abstract class Player implements Attack{

    // 職業別パラメータ（固定値）
    AbilityRange abilityRange;

    // 定数
    final int RANDOM_MAX = 100;
    final int POISON_ID = 1;
    final int PALIZE_ID = 2;
    final String NORMAL_CONDITION = "normal";
    final String POISON_CONDITION = "poison";
    final String PALIZE_CONDITION = "palize";

    // プレイヤーステータス
    protected int jobId; // ジョブのID
    protected String name;
    protected String jobName;
    protected int hp;
    protected int mp;
    protected int str;
    protected int def;
    protected int luck;
    protected int agi;
    protected String condition;

    // コンストラクタ
    public Player(int jobId){
        this.jobId = jobId;
        condition = NORMAL_CONDITION;
    }

    /** --- --- 共通setter & getter --- --- */
    /** --- @return それぞれの能力値範囲 --- */
    public AbilityRange getAbilityRange(){
        return abilityRange;
    }

    /** --- ジョブID --- */
    public int getJobId(){
        return this.jobId;
    }

    /** --- 名前 --- */
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    /** --- ジョブの名前 --- */
    public String getJobName(){
        return this.jobName;
    }

    /** --- HP --- */
    public void setHp(int hp){
        this.hp = hp;
    }

    public int getHp(){
        return this.hp;
    }

    /** --- MP --- */
    public void setMp(int mp){
        this.mp = mp;
    }

    public int getMp(){
        return this.mp;
    }

    /** --- STR(攻撃力) --- */
    public void setStr(int str){
        this.str = str;
    }

    public int getStr(){
        return this.str;
    }

    /** --- DEF(防御力) --- */
    public void setDef(int def){
        this.def = def;
    }

    public int getDef(){
        return this.def;
    }

    /** --- LUCK(幸運度) --- */
    public void setLuck(int luck){
        this.luck = luck;
    }

    public int getLuck(){
        return this.luck;
    }

    /** --- AGI(すばやさ) --- */
    public void setAgi(int agi){
        this.agi = agi;
    }

    public int getAgi(){
        return this.agi;
    }

    /** --- 状態異常 --- */
    public void setCondition(int conditionId){
        switch(conditionId){
            // 毒状態
            case POISON_ID: 
                this.condition = POISON_CONDITION;
            break;

            // 麻痺状態
            case PALIZE_ID:
                this.condition = PALIZE_CONDITION;
            break;

            // 通常状態
            default:
                this.condition = NORMAL_CONDITION;
            break;
        }
    }

    public String getCondition(){
        return condition;
    }

    // すべてのステータスを表示
    public void showAllStatus(){
        System.out.printf("ジョブID: %d, HP: %d, MP: %d, 攻撃力: %d, 防御力: %d, 幸運度: %d, すばやさ: %d",
            this.jobId, this.hp, this.mp, this.str, this.def, this.luck, this.agi
         );
    }

    /** --- --- 共通行動 --- --- */
    /**
     *  通常攻撃を行うメソッド
     * @return ダメージ
     */
    @Override
    public int doNormalAttack(Player player) {
        int damage = this.str - player.getDef();

        // 相手の防御が上回った時ダメージを0にする
        if(damage < 0){
            damage = 0;
        }

        // 会心の一撃判定
        if(isCritical(player.luck)){
            System.out.printf(EnumText.CRITICAL_TEXT.getText());
            damage = this.str;
        }

        return damage;
    }

    /**
     * 会心の一撃かどうかを判定する処理
     * @param luck 幸運度
     * @return 会心の一撃か
     */
    private boolean isCritical(int luck){
        Random ran = new Random();

        return luck - ran.nextInt(RANDOM_MAX)+1 > 0;
    }

    /**
     * MPを消費して魔法が使えるかどうか
     * @return 魔法が使えるか
     */
    protected boolean canActionDecreaseMp(int cost){
        if (this.mp >= cost){
            this.setMp(this.mp - cost);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param attackId
     * @param player
     * @return
     */

    /**
     * 技IDから技を選択する処理
     */
    public int selectAttack(int attackId, Player player){
        int damage = 0;

        switch(attackId){
            default:
            // 攻撃時のテキストとダメージテキスト
            System.out.printf(EnumText.BATTLE_ATTACK_TEXT01.getText(), this.getName());
            damage = doNormalAttack(player);

            // 0ダメージの時テキストを替える
            if(damage == 0){
                System.out.printf(EnumText.BATTLE_ATTACK_MISS_TEXT.getText()); 
            } else {
                System.out.printf(EnumText.BATTLE_ATTACK_TEXT02.getText(), player.getName(), damage); 
            }
            break;
        }

        return damage;
    }
    
    /**
     * ダメージを受けてHPを減らす
     * @param damage 相手からのダメージ
     */
    public void decreaseHp(int damage){
        this.setHp(this.hp - damage);
    }

    /**
     * HPを見て死亡判定
     * @return 死んだかどうか
     */
    public boolean isDead(){
        return this.hp <= 0;
    }
    
}
