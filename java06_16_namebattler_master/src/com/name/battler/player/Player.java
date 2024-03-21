package com.name.battler.player;

import com.name.battler.player.action.Attack;
import com.name.battler.player.action.Rest;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.setting.AbilityRange;
import com.name.battler.setting.battle.PlayerJudge;
import com.name.battler.statustext.EnumText;

/**
 * プレイヤーの基底クラス
 */
public abstract class Player implements Attack, Rest{

    // 定数
    /** 防御アタックID */
    final int ATTACK_DEFENCE = -1;

    // プレイヤーステータス
    /** ジョブID */
    protected int jobId;
    /** キャラの名前 */
    protected String name;
    /** ジョブの名前 */
    protected String jobName;
    /** キャラのHP */
    protected int hp;
    /** キャラのMP */
    protected int mp;
    /** キャラの攻撃力 */
    protected int str;
    /** キャラの防御力 */
    protected int def;
    /** キャラの幸福度 */
    protected int luck;
    /** キャラの素早さ */
    protected int agi;
    /** キャラの状態異常 */
    protected String condition;
    /** 所属するパーティナンバー */
    protected int partyNumber;

    /** 職業別パラメータ */
    protected AbilityRange abilityRange;
    /** 判定メソッド用 */
    protected PlayerJudge pj = new PlayerJudge();


    // コンストラクタ
    public Player(int jobId){
        this.jobId = jobId;
        condition = EnumCondition.NORMAL.getName();
    }

    /** --- --- 共通getter --- --- */
    /** --- @return それぞれの能力値範囲 --- */
    public AbilityRange getAbilityRange(){
        return abilityRange;
    }

    /** --- ジョブID --- */
    public int getJobId(){
        return this.jobId;
    }

    /** --- 名前 --- */
    public String getName(){
        return this.name;
    }

    /** "パーティx の ●●××" */
    public String getLongName(){
        return String.format("パーティ%d の %s%s", 
        this.partyNumber + 1, 
        this.jobName,
        this.name);
    }

    /** --- ジョブの名前 --- */
    public String getJobName(){
        return this.jobName;
    }

    /** --- HP --- */
    public int getHp(){
        return this.hp;
    }

    /** --- MP --- */
    public int getMp(){
        return this.mp;
    }

    /** --- STR(攻撃力) --- */
    public int getStr(){
        return this.str;
    }

    /** --- DEF(防御力) --- */
    public int getDef(){
        return this.def;
    }

    /** --- LUCK(幸運度) --- */
    public int getLuck(){
        return this.luck;
    }

    /** --- AGI(すばやさ) --- */
    public int getAgi(){
        return this.agi;
    }

    /**
     * プレイヤーの状態異常を取得する処理
     * @return 状態異常名
     */
    public String getCondition(){
        return condition;
    }

    /**
     * 名前・HP・MP・こうげき・ぼうぎょ・こううん・すばやさの値をセット
     * @param name プレイヤーの名前
     * @param hp プレイヤーのHP
     * @param mp プレイヤーのMP
     * @param str プレイヤーのこうげき
     * @param def プレイヤーのぼうぎょ
     * @param luck プレイヤーのこううん
     * @param agi プレイヤーのすばやさ
     */
    public void setPlayerStatus(String name, int hp, int mp, int str, int def, int luck, int agi){
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.str = str;
        this.def = def;
        this.luck = luck;
        this.agi = agi;
    }

    /** パーティナンバーをセット */
    public void setPartyNumber(int partyNumber){
        this.partyNumber = partyNumber;
    }

    /** パーティナンバーを取得 */
    public int getPartyNumber(){
        return this.partyNumber;
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
        if(pj.isCritical(this.luck)){
            System.out.printf(EnumText.CRITICAL_TEXT.getText());
            damage = this.str;
        }

        return damage;
    }

    /**
     * 防御行動: 状態異常回復とMP回復
     */
    @Override
    public void doRest(){
        // 状態異常回復
        this.condition = EnumCondition.NORMAL.getName();
        // MP回復
        this.decreaseMp(EnumAction.REST.getCost());
    }

    /**
     * 技IDから技を選択する処理
     */
    public int selectAttack(int attackId, Player player){
        int damage = 0;

        switch(attackId){
            // 防御行動: 状態異常回復とMP回復とダメージ軽減
            case ATTACK_DEFENCE:
                System.out.printf(EnumText.REST_TEXT.getText(), this.getLongName());
                this.doRest();
            break;

            default:
                // 攻撃時のテキストとダメージテキスト
                System.out.printf(EnumText.BATTLE_ATTACK_TEXT01.getText(), this.getLongName());
                damage = doNormalAttack(player);

                // 0ダメージの時テキストを替える
                if(damage == 0){
                    System.out.printf(EnumText.BATTLE_ATTACK_MISS_TEXT.getText()); 
                } else {
                    System.out.printf(EnumText.BATTLE_ATTACK_TEXT02.getText(), player.getLongName(), damage); 
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
        this.hp = this.hp - damage;
    }

    /**
     * MPを消費する処理
     * @param cost 消費するMPコスト
     */
    protected void decreaseMp(int cost){
        this.mp = this.mp - cost;
    }

    /**
     * プレイヤーの状態異常を設定する処理
     * @param condition
     */
    public void setCondition(EnumCondition condition){
        this.condition = pj.getCondition(condition);
    }
}