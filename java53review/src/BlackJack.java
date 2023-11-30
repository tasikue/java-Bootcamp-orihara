import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum Turn{
    Player,
    Dealer
}
/**
 * BlackJack
 */
// ★Genericsの機能を使っているのはなぜでしょうか？
public class BlackJack<E> { 
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

        BlackJack<String> app = new BlackJack<>();

        int playerTotal = 0;
        int comTotal = 0;

        int count=0;
        while(count < 2){
            app.handOutCard(playerCard, count, Turn.Player);
            app.handOutCard(comCard, count, Turn.Dealer);
            count++;
        }

        playerTotal = app.getTotalPoint(playerCard);
        comTotal = app.getTotalPoint(comCard);

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
                    // ★個別で補足したいです
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

    // ★indexを受け取る必要がないです。リストの最後の要素をとるか、
    // 　リストに追加する前に値をString型の変数に入れたら、indexがなくても表示できます
    // ★sideはbooleanとして宣言するとtrueがプレイヤーでfalseがディーラーだと認識しにくい
    // 　今見たいにコメントでカバーする必要がありますが、enum(列挙型)だと分かりやすいです
    private void handOutCard(List<String> list, int index, Turn side) {
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
        // ★ELEVENのスペルミス
        final int EREVEN_POINT = 11;
        // ★Aを1と合計した場合と11と合計した場合の合計を分けていますが、
        // 　Aが複数ある場合に、片方は1として、もう片方は11として数える方法には対応できないです
        int total = 0;
        int totalEleven = 0;

        for (String str : list){
            for(int i=0; i<TRUMP_NUMBER.length; i++){
                if(str.equals(TRUMP_NUMBER[i])){
                    // ★添え字の定数を作った方が良いです
                    if(i == 0){ //A
                        total = total + ONE_POINT;
                        totalEleven = totalEleven + EREVEN_POINT;
                    // ★添え字の定数を作った方が良いです
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