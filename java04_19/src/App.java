
/*
 * 実行するメインクラス
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {

        final int DAY_MAX = 30;
        Player player = new Player();
        
        MessageText.showPrologue();

        int dayCount = 0;
        while(dayCount < 1){
            MessageText.showStartDay(1, player);
            MessageText.showEatItemGet();
            
            dayCount++;
        }
    }
}
