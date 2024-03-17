package com.name.battler;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.name.battler.party.Party;
import com.name.battler.player.Player;
import com.name.battler.player.enumplayer.EnumAction;
import com.name.battler.player.enumplayer.EnumCondition;
import com.name.battler.player.enumplayer.EnumJob;
import com.name.battler.setting.JobManager;
import com.name.battler.setting.PlayerJudge;
import com.name.battler.setting.PlayerMaking;
import com.name.battler.statustext.Dialogue;
import com.name.battler.statustext.EnumText;

/**
 * ゲーム進行に関するクラス
 */
public class GameManager {

    // 定数
    /** 作成するプレイヤー数 */
    final int NAME_COUNT = 6;
    /** 技の数の最大値 */
    final int ACTION_COUNT_MAX = 4;
    /** ランダムの定数 */
    final int RANDOM_HUNDRED = 100;
    final int PALIZE_RANDOM = 20;
    /** パーティメンバー数 */
    final int PARTY_MEMBER_COUNT = 3;

    // 変数
    /** 入力用 */
    private Scanner scan;
    /** ランダム用 */
    private Random ran;
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
        partyList.add(new Party());
        
        // プレイヤーの名前を入力させる
        for(int i=0; i<NAME_COUNT; i++){
            System.out.printf(EnumText.NAME_PUT_TEXT.getText(), i+1);
            playerName[i] = createPlayerName();
            
            // プレイヤーを作成
            PlayerMaking playerMaking = new PlayerMaking(playerName[i], selectJobId());
            playerList.add(playerMaking.getPlayer());

            // 規定メンバー数を超えたら新しくパーティを作成
            if(partyList.get(partyCount).getMembers().size() >= PARTY_MEMBER_COUNT){
                partyCount++;
                partyList.add(new Party());
            }
            // パーティに加入
            partyList.get(partyCount).appendPlayer(playerMaking.getPlayer(), partyCount);

            // プレイヤーのステータスを表示
            Dialogue.showStatusText(playerList.get(i));
        }
        // ここでscanを閉じる
        scan.close();

        // 1. の最後のダイアログ
        // 全パーティの表示(あとでダイアログに組み込む)
        System.out.println(playerList);
        Dialogue.showStartSettingLastText();


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
        while(true){
            // 技をランダムで仕込む
            ran = new Random();

            // 一番早く行動するプレイヤーを取り出す
            Player movePlayer = order.remove(0);

            // 相手の選択
                // 攻撃対象プレイヤーすべてをリストに書き出す
                List<Player> attackPlayerList = new ArrayList<>();
                for(int i=0; i<order.size(); i++){
                    // 同じパーティではない
                    if(movePlayer.getPartyNumber() != order.get(i).getPartyNumber()){
                        // 死んでない
                        if(!pj.isDead(order.get(i))){
                            attackPlayerList.add(order.get(i));
                        }
                    }
                }
                // 攻撃対象リストからランダムで選択
                Player attackPlayer = attackPlayerList.get(ran.nextInt(attackPlayerList.size()));

            // 技行使とダメージ判定: 麻痺の場合20%の確率で動けない
            boolean isPalize = false;
            if(movePlayer.getCondition().equals(EnumCondition.PALIZE.getName())){
                System.out.printf(EnumText.PALIZE_TEXT.getText(), movePlayer.getName(), EnumCondition.PALIZE.getName());
                isPalize = ran.nextInt(RANDOM_HUNDRED) - PALIZE_RANDOM <= 0;
            }

            if(!isPalize){
                // 優先行動選択
                int actionId = ran.nextInt(ACTION_COUNT_MAX);
                // 魔法使いはMPがあるとき呪文優先
                if(movePlayer.getJobId() == EnumJob.WIZARD.getId()){
                    if(movePlayer.getMp() >= EnumAction.THUNDER.getCost()){
                        // random 1-2
                        actionId = ran.nextInt(2)+1;
                    }
                }

                // 僧侶はダメージがあると回復優先
                if(movePlayer.getJobId() == EnumJob.PRIEST.getId()){
                    if(movePlayer.getHp() <= -(EnumAction.HEEL.getDamageRange().getRandomValue())){
                        // 僧侶の回復行動3
                        actionId = 3;
                    }
                }


                // 技行動
                int damage = movePlayer.selectAttack(actionId, attackPlayer);
                attackPlayer.decreaseHp(damage);
            }

            // 死亡判定attackPlayer
            if(pj.isDead(attackPlayer)){
                // チームと行動順から除外
                partyList.get(attackPlayer.getPartyNumber()).removePlayer(attackPlayer);
                order.remove(attackPlayer);

                // テキスト
                System.out.println();
                System.out.printf(EnumText.DEAD_TEXT.getText(), attackPlayer.getName());
                System.out.println();
            }

            // 状態異常判定: 攻撃したほうが毒状態の時ダメージを受ける
            if(movePlayer.getCondition().equals(EnumCondition.POISON.getName())){
                System.out.printf(EnumText.POISON_DAMAGE_TEXT.getText(), movePlayer.getName(), EnumCondition.POISON.getName());
                movePlayer.decreaseHp(EnumCondition.POISON.getDamage());
            }

            // 死亡判定movePlayer(どくにより死亡)
            if(pj.isDead(movePlayer)){
                // チームと行動順から除外
                partyList.get(movePlayer.getPartyNumber()).removePlayer(movePlayer);
                order.remove(movePlayer);

                // テキスト
                System.out.println();
                System.out.printf(EnumText.DEAD_TEXT.getText(), movePlayer.getName());
                System.out.println();
            }

            // 今動いたプレイヤーを行動順の最後に追加する
            order.add(movePlayer);

            // パーティ全滅判定
            if(partyList.get(attackPlayer.getPartyNumber()).getMembers().size() == 0){
                break;
            }
        }

        // 2. の最後のダイアログ
        Dialogue.showStartSettingLastText();


        /* --- 3. 締め --- */
        // 勝者の決定
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
