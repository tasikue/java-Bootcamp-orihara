package com.name.battler.player;

import com.name.battler.player.action.Attack;

/**
 * プレイヤーの基底クラス
 */
public abstract class Player implements Attack{

    // プレイヤーステータス
    protected int jobId; // ジョブのID
    protected int hp;
    protected int mp;
    protected int str;
    protected int def;
    protected int luck;
    protected int agi;
    protected String condition;

    // コンストラクタ
    protected Player(int jobId){
        this.jobId = jobId;
        condition = "通常";
    }

    /** --- --- 共通setter & getter --- --- */
    /** --- ジョブID --- */
    /** --- MP --- */
    public int getJobId(){
        return this.jobId;
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
    protected String getCondition(){
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
     * 通常攻撃を行うメソッド
     * @return ダメージ
     */
    public int doNormalAttack(int enemyDef){
        return this.str - enemyDef;
    }
}