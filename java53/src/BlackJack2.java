import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BlackJack
 * チャレンジ01: ブラックジャック判定
 */
public class BlackJack2<E> {

    private final String[] TRUMP_NUMBER = {
            "A","2","3","4","5","6","7"
            ,"8","9","10","J","Q","K"
        };

    private static final int BLACKJACK_NUMBER = 21;

    public static void main(String[] args) {

        final boolean PLAYER_SIDE = true;
        final boolean COM_SIDE = false;

        List<String> playerCard = new ArrayList<>();
        List<String> comCard = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        BlackJack2<String> app = new BlackJack2<>();

        int playerTotal = 0;
        int comTotal = 0;

        int count=0;
        while(count < 2){
            app.handOutCard(playerCard, count, PLAYER_SIDE);
            app.handOutCard(comCard, count, COM_SIDE);
            count++;
        }

        playerTotal = app.getTotalPoint(playerCard);
        comTotal = app.getTotalPoint(comCard);

        // チャレンジ01: ブラックジャック判定
        if(playerTotal == BLACKJACK_NUMBER){
            System.out.println("ブラックジャックなのであなたの勝ちです。");
            System.exit(0);
        }

        if(comTotal == BLACKJACK_NUMBER){
            System.out.println("ブラックジャックなのであなたの負けです。");
            System.exit(0);
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
                app.handOutCard(playerCard, playerIndex, PLAYER_SIDE);
                playerTotal = app.getTotalPoint(playerCard);
                playerIndex++;

                if(playerTotal > BLACKJACK_NUMBER){
                    System.out.println("バーストしたのであなたの負けです。");
                    System.exit(0);
                }
            } else {
                System.out.println();
                scan.close();
                break;
            }
        }

        int comIndex = count;
        while(true){
            app.handOutCard(comCard, comIndex, COM_SIDE);
            comTotal = app.getTotalPoint(comCard);
            comIndex++;
            System.out.printf("ディーラーの合計は %d です。\n", comTotal);
            System.out.println();

            if(comTotal > BLACKJACK_NUMBER){
                System.out.println("バーストしたのであなたの勝ちです。");
                System.exit(0);
            }

            if(comTotal > 17) break;
        }

        if(playerTotal > comTotal){
            System.out.println("あなたの勝ちです");
        }else if(playerTotal < comTotal){
            System.out.println("あなたの負けです");
        } else {
            System.out.println("引き分けです");
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