import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BlackJack
 *  チャレンジ02: コインを賭ける
 *  手持ち 100 コインでコインが 0 になると終了
 *  １回あたり 10 コインを賭ける
 *  ブラックジャックで勝ち: 30 コインの払い戻し
 *  ブラックジャック以外で勝ち: 20 コインの払い戻し
 *  引き分け: 10 コイン（掛け金）の払い戻し
 *  負け: 払い戻しなし（賭け金没収）
 */

public class BlackJack3<E> {

    private final String[] TRUMP_NUMBER = {
            "A","2","3","4","5","6","7"
            ,"8","9","10","J","Q","K"
        };

    private int coin = 100;
    // ★払い戻しのコイン数を配列に入れると
    // 　どの数値がどんな時に使われるのか分かりづらい
    private final int[] BET_COINS = {10, 20, 30};

    private static final int BLACKJACK_NUMBER = 21;

    // ★追加
    private static Scanner scan;

    public static void main(String[] args) {

        BlackJack3<String> app = new BlackJack3<>();
        // ★Scannerは扱い方に注意が必要です
        // 　closeする癖を付けましょう
        // 　また、引数としてインスタンスを渡す必要がないように
        // 　メンバ変数にすることができます

        // ★変更
        //Scanner scan = new Scanner(System.in);
        scan = new Scanner(System.in);

        boolean hasCoin;

        if(app.coin == 0){
            hasCoin = false;
        } else {
            hasCoin = true;
        }
        
        while(hasCoin){
            // ★変更
            // app.blackjackGame(scan);
            app.blackjackGame();
            System.out.println();
            System.out.printf("現在のコインは %d \n", app.coin);
            System.out.println();
        }
        // ★追加
        scan.close();
    }

    // ★変更
    // private void blackjackGame(Scanner scan) {
    private void blackjackGame() {
        
        final boolean PLAYER_SIDE = true;
        final boolean COM_SIDE = false;

        List<String> playerCard = new ArrayList<>();
        List<String> comCard = new ArrayList<>();

        int playerTotal = 0;
        int comTotal = 0;

        coin = coin - BET_COINS[0];
        int count=0;
        while(count < 2){
            handOutCard(playerCard, count, PLAYER_SIDE);
            handOutCard(comCard, count, COM_SIDE);
            count++;
        }

        playerTotal = getTotalPoint(playerCard);
        comTotal = getTotalPoint(comCard);

        // チャレンジ01: ブラックジャック判定
        if(playerTotal == BLACKJACK_NUMBER){
            System.out.println("ブラックジャックなのであなたの勝ちです。");
            coin = coin + BET_COINS[2];
            return;
        }

        if(comTotal == BLACKJACK_NUMBER){
            System.out.println("ブラックジャックなのであなたの負けです。");
            return;
        }

        System.out.println();
        System.out.printf("ディーラーの合計は %d です。\n", comTotal);

        int playerIndex = count;
        while(true){
            System.out.printf("現在の合計は %d です。\n", playerTotal);
            System.out.printf("もう一度カードを引きますか？(Y/N): ");
            String answer = scan.nextLine();

            if(answer.equals("Y")){
                System.out.println();
                handOutCard(playerCard, playerIndex, PLAYER_SIDE);
                playerTotal = getTotalPoint(playerCard);
                playerIndex++;

                if(playerTotal > BLACKJACK_NUMBER){
                    System.out.println("バーストしたのであなたの負けです。");
                    return;
                }
            } else {
                System.out.println();
                break;
            }
        }

        int comIndex = count;
        while(true){
            handOutCard(comCard, comIndex, COM_SIDE);
            comTotal = getTotalPoint(comCard);
            comIndex++;
            System.out.printf("ディーラーの合計は %d です。\n", comTotal);
            System.out.println();

            if(comTotal > BLACKJACK_NUMBER){
                System.out.println("バーストしたのであなたの勝ちです。");
                coin = coin + BET_COINS[1];
                return;
            }

            if(comTotal > 17) break;
        }

        if(playerTotal > comTotal){
            System.out.println("あなたの勝ちです");
            coin = coin + BET_COINS[1];
        }else if(playerTotal < comTotal){
            System.out.println("あなたの負けです");
        } else {
            System.out.println("引き分けです");
            coin = coin + BET_COINS[0];
        }
    }

    private void handOutCard(List<String> list, int index, boolean side) {
        Random ran = new Random();

        list.add(TRUMP_NUMBER[ran.nextInt(TRUMP_NUMBER.length)]);

        // side: true->あなた false->ディーラー
        if(side){
            System.out.printf("あなたに 「%s」 が配られました。\n", list.get(index));
        } else {
            System.out.printf("ディーラーに 「%s」 が配られました。\n", list.get(index));
        }
    }

    private int getTotalPoint(List<String> list){
        final int ONE_POINT = 1;
        final int TEN_POINT = 10;
        final int EREVEN_POINT = 11;
        
        int total = 0;
        int totalEleven = 0;

        for (String str : list){
            for(int i=0; i<TRUMP_NUMBER.length; i++){
                if(str.equals(TRUMP_NUMBER[i])){
                    if(i == 0){ //A
                        total = total + ONE_POINT;
                        totalEleven = totalEleven + EREVEN_POINT;
                    } else if (i > 9) { // J, Q, K
                        total = total + TEN_POINT;
                        totalEleven = totalEleven + TEN_POINT;
                    } else {
                        total = total + Integer.parseInt(str);
                        totalEleven = totalEleven + Integer.parseInt(str);
                    }
                }
            }
        }

        if(totalEleven > BLACKJACK_NUMBER){
            return total;
        } else {
            return totalEleven;
        }
    }
}