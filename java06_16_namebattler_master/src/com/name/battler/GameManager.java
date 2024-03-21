package com.name.battler;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.name.battler.player.Party;
import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.setting.JobManager;
import com.name.battler.setting.PlayerMaking;
import com.name.battler.setting.battle.PlayerJudge;
import com.name.battler.setting.battle.strategy.*;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

/**
 * ゲーム進行に関するクラス
 */
public class GameManager {

    // 定数
    /** 作成するプレイヤー数 */
    final int NAME_COUNT = 6;
    /** ランダムの定数 */
    final int RANDOM_HUNDRED = 100;
    final int PALIZE_RANDOM = 20;
    final int TEN_PERCENT  = 10;
    /** 作戦数 */
    final int STRATEGY_COUNT = 5;
    /** 休憩attackID */
    final int REST_ATTACKID = -1;

    // 変数
    /** 入力用 */
    private Scanner scan;
    /** ランダム用 */
    private Random random = new Random();
    /** 作成したプレイヤークラスを格納するリスト */
    private List<Player> playerList = new ArrayList<>();
    /** 作成したパーティクラスを格納するリスト */
    private List<Party> partyList = new ArrayList<>();
    /** 判定用 */
    private PlayerJudge pj = new PlayerJudge();

    /**
     * メイン進行
     * 1. プレイヤーの作成
     * 2. 戦闘開始
     * 3. 終了
     */
    public void Start(){
        // 1. の最初のダイアログ
        Dialogue.showStartSettingText();

        /* --- 1. プレイヤーの作成 --- */
        // プレイヤーネームのためのリストを用意
        String[] playerName = new String[NAME_COUNT];

        // 今回作成するパーティを用意
        int partyCount = 0;
        partyList.add(new Party(random.nextInt(STRATEGY_COUNT)));
        
        // プレイヤーの名前を入力させる
        for(int i=0; i<NAME_COUNT; i++){
            System.out.printf(EnumText.NAME_PUT_TEXT.getText(), i+1);
            playerName[i] = createPlayerName();
            
            // プレイヤーを作成
            PlayerMaking playerMaking = new PlayerMaking(playerName[i], selectJobId());
            playerList.add(playerMaking.getPlayer());

            // 規定メンバー数を超えたら新しくパーティを作成
            if(partyList.get(partyCount).getMembers().size() >= Party.getMaxPartyCount()){
                partyCount++;
                partyList.add(new Party(random.nextInt(STRATEGY_COUNT)));
            }
            // パーティに加入
            partyList.get(partyCount).appendPlayer(playerMaking.getPlayer(), partyCount);

            // プレイヤーのステータスを表示
            Dialogue.showStatusText(playerList.get(i));
        }
        // ここでscanを閉じる
        scan.close();

        // 全パーティの表示
        Dialogue.showStartSettingLastText(partyList);


        /* --- 2. バトルフェイズ --- */
        // 2. の最初のダイアログ
        Dialogue.showStartBattleText();

        // orderリストで素早さ早い順でソートする
        List<Player> order = new ArrayList<>(playerList);
        Comparator<Player> agiComparator = new Comparator<Player>(){
             @Override
             public int compare(Player player1, Player player2){
                 return player2.getAgi() - player1.getAgi();
            }
        };
        Collections.sort(order, agiComparator);

        // 戦闘ループ 
        boolean isBattleEnd = false;
        while(!isBattleEnd){
            // 行動するプレイヤー
            Player movePlayer = null;
            // 攻撃対象のプレイヤー
            Player targetPlayer = null;


            // 行動プレイヤーの選択: 一番早く行動するプレイヤーを取り出す
            movePlayer = order.remove(0);

            // 攻撃対象プレイヤーすべてをリストに書き出す
            List<Player> targetPlayerList = new ArrayList<>();
            for(int i=0; i<order.size(); i++){
                // 同じパーティではない
                if(movePlayer.getPartyNumber() != order.get(i).getPartyNumber()){
                    // 死んでない
                    if(!pj.isDead(order.get(i))){
                        targetPlayerList.add(order.get(i));
                    }
                }
            }

            // 技行使とダメージ判定: 麻痺の場合20%の確率で動けない
            boolean isPalize = false;
            if(movePlayer.getCondition().equals(EnumCondition.PALIZE.getName())){
                System.out.printf(EnumText.PALIZE_TEXT.getText(), movePlayer.getLongName(), EnumCondition.PALIZE.getName());
                isPalize = random.nextInt(RANDOM_HUNDRED) - PALIZE_RANDOM <= 0;
            }

            if(!isPalize){
                // パーティの行動指針を決める処理
                int attackId = 0;

                // 戦略の決定
                switch (partyList.get(movePlayer.getPartyNumber()).getCurrendStrategy()) {
                    case 0: // 作戦2: 攻撃しか選択しない
                        Activity activity2 = new Activity(new AttackOnlyStrategy());
                        targetPlayer = activity2.getTargetPlayer(targetPlayerList);
                        attackId = activity2.getActionId(movePlayer);
                    break;

                    case 1: // 作戦3: HPが低いのを狙う
                        Activity activity3 = new Activity(new AimWeakOpponentStrategy());
                        targetPlayer = activity3.getTargetPlayer(targetPlayerList);
                        attackId = activity3.getActionId(movePlayer);
                    break;

                    case 2: // 作戦4: とりあえず回復優先
                        Activity activity4 = new Activity(new FirstMoveHeelStrategy());
                        targetPlayer = activity4.getTargetPlayer(targetPlayerList);
                        attackId = activity4.getActionId(movePlayer);
                    break;

                    case 3: // 作戦5: 僧侶は許さない
                        Activity activity5 = new Activity(new AimPriestStrategy());
                        targetPlayer = activity5.getTargetPlayer(targetPlayerList);
                        attackId = activity5.getActionId(movePlayer);
                    break;

                    default:
                    // 作戦1: 攻撃対象リストからランダムで選択
                        Activity activity1 = new Activity(new RandomStrategy());
                        targetPlayer = activity1.getTargetPlayer(targetPlayerList);
                        attackId = activity1.getActionId(movePlayer);
                    break;
                }

                // 追加要素: たまにはやすむ 100/10
                // 効果: 状態異常回復 and mp回復
                if(random.nextInt(RANDOM_HUNDRED) - TEN_PERCENT <= 0){
                    // -1は固定で休憩
                    attackId = REST_ATTACKID;
                }

                // 技行動
                int damage = movePlayer.selectAttack(attackId, targetPlayer);
                targetPlayer.decreaseHp(damage);


                // 死亡判定targetPlayer
                if(pj.isDead(targetPlayer)){
                    // チームと行動順から除外
                    partyList.get(targetPlayer.getPartyNumber()).removePlayer(targetPlayer);
                    order.remove(targetPlayer);
                    // テキスト
                    Dialogue.showDeadPlayerText(targetPlayer);
                }
            }

            // 状態異常判定: 攻撃したほうが毒状態の時ダメージを受ける
            if(movePlayer.getCondition().equals(EnumCondition.POISON.getName())){
                System.out.printf(EnumText.POISON_DAMAGE_TEXT.getText(), movePlayer.getLongName(), EnumCondition.POISON.getName());
                movePlayer.decreaseHp(EnumCondition.POISON.getDamage());
            }

            // 死亡判定movePlayer(どくにより死亡)
            if(pj.isDead(movePlayer)){
                // チームと行動順から除外
                partyList.get(movePlayer.getPartyNumber()).removePlayer(movePlayer);
                order.remove(movePlayer);
                // テキスト
                Dialogue.showDeadPlayerText(movePlayer);
            }

            // 今動いたプレイヤーを行動順の最後に追加する
            order.add(movePlayer);

            // パーティ全滅判定
            for(int i=0; i<partyList.size(); i++){
                if(partyList.get(i).isPartyAnnihilation()){
                    isBattleEnd = true;
                }
            }
        }

        /* --- 3. 締め --- */
        // 勝者の決定
        System.out.printf(EnumText.WINNER_TEAM_TEXT.getText(), order.get(0).getPartyNumber() + 1);

        // ステータス表示
        for(int i=0; i<order.size(); i++){
            Dialogue.showStatusText(order.get(i));
        }
    }


    /**
     * プレイヤーネームの入力を受け付けそれを出力する
     * @return プレイヤーネーム
     */
    private String createPlayerName(){
        // 日本語入力文字化け対策 Shift-JIS
        scan = new Scanner(System.in, "Shift-JIS");

        // 変数
        String playerName = "";

        // 名前を入力（例外の場合やり直す）
        while(true){
            if(scan.hasNextLine()){
                // 名前を入力させ成功したら抜ける
                playerName = scan.nextLine();
                break;
            } else {
                // もう一度入力させる
                System.out.println(EnumText.CREATE_PLAYER_NAME_ATTENTION_TEXT.getText());
                scan.nextLine();
            }
        }

        return playerName;
    }

    /**
     * ジョブIDの入力を受け付けそれを出力する
     * @return ジョブID
     */
    private int selectJobId(){
        // 日本語入力文字化け対策 Shift-JIS
        scan = new Scanner(System.in, "Shift-JIS");

        // 全ジョブを出力
        JobManager jm = new JobManager();
        for(Player job : jm.getJobList()){
            System.out.printf("%s: %d  ", job.getJobName(), job.getJobId());
        }

        // 変数
        boolean isValidInput = false;
        int jobId = 0;

        // 名前を入力（例外の場合やり直す）
        while(!isValidInput){
            if(scan.hasNextInt()){
                // 名前を入力させ成功したら抜ける
                jobId = scan.nextInt();

                // ジョブが指定数以内で確定
                if(jobId < jm.getJobList().size()){
                    isValidInput = true;
                } else {
                    // エラーメッセージ
                    System.out.println(EnumText.SELECT_JOB_ATTENTION_TEXT02.getText());
                }
            } else {
                // エラーメッセージをだしもう一度入力させる
                System.out.println(EnumText.SELECT_JOB_ATTENTION_TEXT01.getText());
                scan.nextLine();
            }
        }

        return jobId;
    }
}
