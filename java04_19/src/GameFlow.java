import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import eatitem.*;

/**
 * ゲーム全体の流れを記述したクラス
 */
public class GameFlow {

    /** 最大日数 */
    private final int DAY_MAX = 30;

    /** 日々の記録を保持するリスト */
    private List<EatItemHistory> histories = new ArrayList<>();
    /** プレイヤー */
    private Player player = new Player();
    /** スキャンクラス */
    private Scanner scan = new Scanner(System.in);

    /**
     * 全体のゲームの流れ
     */
    public void Flow(){
        // スタート時のテキスト表示
        MessageText.showPrologueText(DAY_MAX);

        // 最初の日の日数と食べ物を準備
        int dayCount = 1;
        EatItem nextDinner = EnumEatItem.getDinner();
        // 最終日までループ
        while(dayCount <= DAY_MAX){
            // 今日始めのテキスト表示
            MessageText.showGoodMorningText(dayCount, player);

            // その日と次の日の食べ物を用意
            EatItem dinner = nextDinner;
            nextDinner = EnumEatItem.getDinner();
            //今日のご飯のテキスト表示
            MessageText.showEatItemGetText(dinner);

            // フラグの準備
            boolean isDoEat = false;
            boolean selected = false;

            // 選択するまでループ
            while(!selected){
                // 食べるかどうかを選択させるテキスト表示
                MessageText.showAskingEatText(dinner);
                // 任意の文字を入力させる
                String answer =  scan.nextLine();

                // y -> 食べる, n -> 食べない, h -> ヒント
                switch(answer){

                    case "y":
                        isDoEat = true;
                        if(dinner.canEat()){
                            // 食べることができた場合のテキスト表示
                            MessageText.showEatItemCanEatingText(dinner);
                            // HPの回復
                            player.setPlayerHp(dinner.getExpectedHeelingHP());
                        } else {
                            // 食べられなかった場合のテキスト表示
                            MessageText.showEatItemCanNotEatingText(dinner);
                            // プレイヤー死亡
                            player.instantDeath();
                        }
                        // 選択済み
                        selected = true;
                    break;
                
                    case "n":
                        isDoEat = false;
                        // 食べなかった場合のテキスト表示
                        MessageText.showEatItemNotEatingText(dinner);
                        // hp判定
                        player.setHungryDamage();
                        // 選択済み
                        selected = true;
                    break;

                    case "h":
                    if(player.canUseHint()){
                        // 次の日のヒントテキスト表示
                        MessageText.showEatItemNextGetText(nextDinner);
                    } else {
                        // ヒント回数0の時のテキスト表示
                        MessageText.showNotHasHintText();
                    }
                    break;

                    default:
                        // 入力のし直しテキスト表示
                        MessageText.showDecideText();
                    break;
                }
            }

            // この日の記録を保持
            histories.add(new EatItemHistory(dayCount, player.getHp(), dinner, isDoEat));

            // 空腹度合いのテキスト表示
            MessageText.showHungryText(player.getHp());

            // ゲームオーバー判定
            if(!player.getIsLife()){
                // ゲームオーバーテキスト表示
                MessageText.showYourDeadText();
                break;
            }

            // ゲームクリア判定
            boolean isXDay = dayCount >= DAY_MAX;
            if(isXDay){
                // ゲームクリア時のテキスト表示
                MessageText.showGameClearText();
                break;
            }

            // その日の終わりのテキスト表示
            MessageText.showGoodNightText();
            dayCount++;
        }

        // ゲームオーバー時のテキスト表示
        MessageText.showGameOverText();
        // すべての記録を表示
        for(EatItemHistory history : histories){
            MessageText.showHistoryText(history);
        }
        scan.close();
    }
}