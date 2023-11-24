import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * BlackJack
 */
public class BlackJack {

    private final String[] CARD = {
            "A","2","3","4","5","6","7","8","9","10","J","Q","K"
        };

    public static void main(String[] args) {

        Random ran = new Random();

        ArrayList<String> yourCard = new ArrayList<>();
        ArrayList<String> comCard = new ArrayList<>();

        int count=0;
        while(count < 2){
        /*yourCard.add(card[ran.nextInt(card.length)]);
        comCard.add(card[ran.nextInt(card.length)]);*/

        System.out.printf("あなたに 「%s」 が配られました。\n", yourCard.get(count));
        System.out.printf("ディーラーに 「%s」 が配られました。\n", comCard.get(count));
        count++;
        }

        System.out.println();

        // ここに合計
    }

    private static void handOutCard(ArrayList list, int index) {
        Random ran = new Random();

        list.add(card[ran.nextInt(card.length)]);
        System.out.printf("あなたに 「%s」 が配られました。\n", yourCard.get(count));
    }
}