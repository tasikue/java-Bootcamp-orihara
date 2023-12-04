import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * BlackJack
 */

public class BlackJack {

    private final String[] TRUMP_NUMBER = {
            "A","2","3","4","5","6","7"
            ,"8","9","10","J","Q","K"
        };

    private static final int BLACKJACK_NUMBER = 21;

    private enum Character{
        PLAYER,
        DEALER
    }

    public static void main(String[] args) {

        final int COM_MAX = 17;

        List<String> playerCard = new ArrayList<>();
        List<String> comCard = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        BlackJack app = new BlackJack();

        int playerTotal = 0;
        int comTotal = 0;

        boolean isEnd = false;

        int count=0;
        while(count < 2){
            app.handOutCard(playerCard, Character.PLAYER);
            app.handOutCard(comCard, Character.DEALER);
            count++;
        }

        playerTotal = app.getTotalPoint(playerCard);
        comTotal = app.getTotalPoint(comCard);

        System.out.println();
        System.out.printf("ディーラーの合計は %d です。\n", comTotal);


        while(true){
            System.out.printf("現在の合計は %d です。\n", playerTotal);
            System.out.printf("もう一度カードを引きますか？(Y/N): ");
            String answer = scan.nextLine();

            if(answer.equals("Y")){
                System.out.println();
                app.handOutCard(playerCard, Character.PLAYER);
                playerTotal = app.getTotalPoint(playerCard);

                if(playerTotal > BLACKJACK_NUMBER){
                    System.out.println("バーストしたのであなたの負けです。");
                    isEnd = true;
                    // ★再提出は不要ですがScannerのcloseは
                    // 　mainメソッドの最後に移動させると一か所で済みます
                    scan.close();
                    break;
                }
            } else {
                System.out.println();
                scan.close();
                break;
            }
        }

        while((comTotal <= COM_MAX) && !isEnd){
            app.handOutCard(comCard, Character.DEALER);
            comTotal = app.getTotalPoint(comCard);

            System.out.printf("ディーラーの合計は %d です。\n", comTotal);
            System.out.println();

            if(comTotal > BLACKJACK_NUMBER){
                System.out.println("バーストしたのであなたの勝ちです。");
                isEnd = true;
                break;
            }
        }

        if(!isEnd){
            if(playerTotal > comTotal){
                System.out.println("あなたの勝ちです");
            }else if(playerTotal < comTotal){
                System.out.println("あなたの負けです");
            } else {
                System.out.println("引き分けです");
            }
        }
    }
    

    private void handOutCard(List<String> list, Character side) {
        Random ran = new Random();

        list.add(TRUMP_NUMBER[ran.nextInt(TRUMP_NUMBER.length)]);

        if(side.toString() == "PLAYER"){
            System.out.printf("あなたに 「%s」 が配られました。\n", list.get(list.size()-1));
        } else if(side.toString() == "DEALER") {
            System.out.printf("ディーラーに 「%s」 が配られました。\n", list.get(list.size()-1));
        }
    }

    private int getTotalPoint(List<String> list){
        final int ONE_POINT = 1;
        final int TEN_POINT = 10;
        final int ELEVEN_POINT = 11;
        final int A_INDEX = 0;
        final int JACK_INDEX = 10;
        
        int total = 0;
        int totalEleven = 0;
        // ★このような場合はhasAceとかhasAのようにhas〇〇と名前を付けるようにしましょう
        // 　命名規則については以下参照
        // 　参考情報：https://qiita.com/GinGinDako/items/6e8b696c4734b8e92d2b
        boolean isAhave = false;

        // ★プログラムを書き換えてもらいましたが、
        // 　少し考えすぎているかと思います。
        // 　点数を数えるときは先に1点又は11点で点数を集計して、
        // 　最後に必要に応じて調整する事もできるのではないでしょうか？
        // 　例）A,J,Jを引いて、仮に11点で計算すると31点になります
        // 　　　このときにAを引いていた場合、点数を引くことで調整が可能です。
        // 　　　もう少しアルゴリズムがシンプルになりそうではないでしょうか？
        for (String str : list){
            for(int i=0; i<TRUMP_NUMBER.length; i++){
                if(str.equals(TRUMP_NUMBER[i])){
                    if(i == A_INDEX){ //A
                        total = total + ONE_POINT;
                        if(isAhave){
                            totalEleven = totalEleven + ONE_POINT;
                        } else {
                            totalEleven = totalEleven + ELEVEN_POINT;
                            isAhave = true;
                        }
                    } else if (i >= JACK_INDEX) { // J, Q, K
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