import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*
 * 実行するメインクラス
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {

        final int DAY_MAX = 30;
        List<EatItemHistory> histories = new ArrayList<>();
        Player player = new Player();
        Scanner scan = new Scanner(System.in);
        
        MessageText.showPrologueText(DAY_MAX);

        int dayCount = 1;
        EatItem nextDinner = EatItemManager.getDinner();
        while(dayCount <= DAY_MAX){
            MessageText.showGoodMorningText(dayCount, player);

            // その日と次の日の食べ物を用意
            EatItem dinner = nextDinner;
            nextDinner = EatItemManager.getDinner();
            //今日のご飯の表示
            MessageText.showEatItemGetText(dinner);

            // フラグの準備
            boolean isDoEat = false;
            boolean isGameOver = false;
            boolean isNotDesided = true;
            while(isNotDesided){
                MessageText.showAskingEatText(dinner);
                String answer =  scan.nextLine();

                switch(answer){
                    // 食べた時
                    case "y":
                        isDoEat = true;
                        if(dinner.canEat()){
                            // 食べることができた場合
                            MessageText.showEatItemCanEatingText(dinner);
                            // hp判定
                            isGameOver = player.isDeadCalcHp(dinner.getExpectedHeelingHP());
                        } else {
                            // 食べられなかった場合
                            MessageText.showEatItemCanNotEatingText(dinner);
                            isGameOver = player.isDeadZeroHp();
                        }
                        isNotDesided = false;
                    break;
                
                    // 食べない場合
                    case "n":
                        isDoEat = false;
                        MessageText.showEatItemNotEatingText(dinner);
                        // hp判定
                        isGameOver = player.isDeadCalcHp();
                        isNotDesided = false;
                    break;

                    // ヒント
                    case "h":
                    if(player.isCanUseHint()){
                        MessageText.showEatItemNextGetText(nextDinner);
                    } else {
                        MessageText.showNotHasHintText();
                    }
                    break;

                    default:
                        MessageText.showDecideText();
                    break;
                }
            }

            // この日の記録
            histories.add(new EatItemHistory(dayCount, player.getHp(), dinner, isDoEat));

            // 空腹度合い
            MessageText.showHungryText(player.getHp());

            // ゲームオーバー判定
            if(isGameOver){
                MessageText.showYourDeadText();
                break;
            }

            // ゲームクリア判定
            boolean isXDay = dayCount >= DAY_MAX;
            if(isXDay){
                MessageText.showGameClearText();
                break;
            }

            MessageText.showGoodNightText();
            dayCount++;
        }

        MessageText.showGameOverText();
        for(EatItemHistory history : histories){
            MessageText.showHistoryText(history);
        }
        scan.close();
    }
}
