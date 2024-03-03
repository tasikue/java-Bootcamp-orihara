package com.name.battler.player;

import java.util.Random;

import com.name.battler.player.action.Attack;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.statustext.EnumText;

/**
 * プレイヤーの基底クラス
 */
public abstract class Player implements Attack{

    // 職業別パラメータ
    protected AbilityRange abilityRange;

    // 定数
    final int RANDOM_MAX = 100;

    // プレイヤーステータス
    protected int jobId; // ジョブのID
    protected String name; // キャラの名前
    protected String jobName; // ジョブの名前
    protected int hp; // キャラのHP
    protected int mp; // キャラのMP
    protected int str; // キャラの攻撃力
    protected int def; // キャラの防御力
    protected int luck; // キャラの幸福度
    protected int agi; // キャラの素早さ
    protected String condition; // キャラの状態異常

    // コンストラクタ
    public Player(int jobId){
        this.jobId = jobId;
        condition = EnumCondition.NORMAL.getConditionName();
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
    public String getName(){
        return this.name;
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

    /** --- 状態異常 --- */
    /**
     * 列挙型のEnumConditionクラスにより状態異常を設定する処理
     * @param condition
     */
    public void setCondition(EnumCondition condition){
        switch(condition){
            // 毒状態
            case POISON: 
                this.condition = EnumCondition.POISON.getConditionName();
            break;

            // 麻痺状態
            case PALIZE:
                this.condition = EnumCondition.PALIZE.getConditionName();
            break;

            // 通常状態
            default:
                this.condition = EnumCondition.NORMAL.getConditionName();
            break;
        }
    }

    /**
     * プレイヤーの状態異常を得る処理
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

    /**
     * すべてのステータスを表示
     */
    public void showAllStatus(){
        System.out.printf(EnumText.PLAYER_STATUS_TEXT.getText(),
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
            this.mp = this.mp - cost;
            return true;
        }
        return false;
    }

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
        this.hp = this.hp - damage;
    }

    /**
     * HPを見て死亡判定
     * @return 死んだかどうか
     */
    public boolean isDead(){
        return this.hp <= 0;
    }
    
}
