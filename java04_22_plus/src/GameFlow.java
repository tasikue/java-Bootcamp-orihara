import java.util.InputMismatchException;
import java.util.Scanner;

import captureball.CaptureBall;
import captureball.CaptureBallList;
import monster.Monster;
import monster.MonsterData;

import java.util.List;
import java.util.ArrayList;

/**
 * ゲーム全体の
 * @author orihara
 * @version 1.0
 */
public class GameFlow {

    static Scanner scan;

    public void Flow(){
        /** 繰り返す最大回数 */
        final int PHASE_COUNT_MAX = 10;
        /** 捕獲したモンスターのリスト */
        List<Monster> capturedMonsterList = new ArrayList<>();
        CaptureBallList captureBallList = new CaptureBallList();
        
        // 遊び方説明
        MessageText.showPrologeText();

        // バトルループ
        int monsterCount=0;
        Start: while(monsterCount < PHASE_COUNT_MAX){
            /* スタンバイフェイズ */
            MessageText.showStanbyPhaseText();

            /* バトルフェイズ */
            // 今回のモンスターを選択
            MonsterData tempMD = MonsterData.getRandomMonsterData();
            Monster targetMonster = new Monster(
                tempMD.getName(),
                tempMD.getHpValue(),
                tempMD.getPowerValue(),
                tempMD.getDefenceValue(),
                tempMD.getEncountRate(),
                tempMD.getCaptureRate());
            MessageText.showBattlePhaseOneText(captureBallList, targetMonster);
        
            boolean isBattleEnd = false;
            boolean isAllBattleEnd;
            while (!isBattleEnd) {
                // コマンド選択
                int ballIndex = inputIndex(captureBallList.getListLength()) -1; // inputした数値をリストのインデックスに戻す

                // 逃げることを選択肢た場合
                if(ballIndex == captureBallList.getListLength()){
                    MessageText.showBattlePhaseRunAweyText();
                    isBattleEnd = true;

                    // 終了判定
                    monsterCount++;
                    isAllBattleEnd = monsterCount >= PHASE_COUNT_MAX;
                    if(isAllBattleEnd){
                        MessageText.showBattleEndNotPhaseBallText();
                        break Start;
                    }

                    MessageText.showBattlePhaseThreeText();
                    continue Start; // ここで戻る
                }

                // 捕獲開始
                CaptureBall targetBall = captureBallList.getCaptureBall(ballIndex);
                MessageText.showBattlePhaseTweText(targetBall);
                targetBall.use();
                captureBallList.deleteCaptureBall();
        
                // 捕獲成功判定
                if(targetMonster.canCaputured(targetBall.getCorrectValue())){
                    // 捕獲成功
                    MessageText.showBattlePhaseTweSuccessText(targetMonster);
                    capturedMonsterList.add(targetMonster);
                    isBattleEnd = true;
                } else {
                    // 捕獲失敗
                    MessageText.showBattlePhaseTweFailureText(targetMonster);
                }

                // ボールがなくなった時の終了判定
                boolean hasCaptureBall = captureBallList.isEmptyBallList();
                if(hasCaptureBall){
                    MessageText.showBattleEndNothaveBallText();
                    break Start;
                }

                // 捕獲失敗時に継続する
                if(!isBattleEnd){
                    MessageText.showBattlePhaseTweFailureNextText(captureBallList, targetMonster);
                }
            }

            /* エンドフェイズ */
            monsterCount++;
            isAllBattleEnd = monsterCount >= PHASE_COUNT_MAX;
            if(isAllBattleEnd){
                MessageText.showBattleEndNotPhaseBallText();
                break Start;
            }

            MessageText.showBattlePhaseThreeText();
        }

        scan.close();
        MessageText.showCapturedMonsterList(capturedMonsterList);
    }

    
/**
     * 入力を受けてそれが想定通りの数値か判定する処理
     * @param 選択肢の配列の長さ
     * @return 選んだインデックス
     */
    private static int inputIndex(int length){
        scan = new Scanner(System.in);
        int input;

        while (true){ 

            // inputに数値以外が入力されたときの処理
            try {
                // 想定数値1~4
                input = scan.nextInt();

            } catch (InputMismatchException e){
                System.out.println("数値を入力してください");
                scan.next();
                continue;
            }

            // 想定数値遺骸が入力されたときの処理
            if(input <= 0 || input > length + 1){
                System.out.println("指定数値を入力してください");
                continue;
            }
            break;
        }

        return input;
    }
}
