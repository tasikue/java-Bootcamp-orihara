import java.util.Random;

public class BattleField {

    private static final int MAX_TURN_NO = 5;
    
    public static void main(String[] args) {

        BattleField app = new BattleField();
        app.showConsoleText("処理をスタートします");

        String[] players = { "山本", "浜田", };

        for (int i = 1; i <= MAX_TURN_NO; i++) {

            String attackerName = getRandomAttackerName(players);
            String defenderName = getDefenderName(players, attackerName);

            showTurn(i);
            showAttackText(attackerName, defenderName);
        }

        app.showConsoleText("処理を終わります");
    }

    private void showConsoleText(String message){
        System.out.println("-----");
        System.out.println(message);
        System.out.println("-----");
        System.out.println();
    }

    private static String getRandomAttackerName(String[] players){

        Random rand = new Random();
        return players[rand.nextInt(players.length)];
    }

    private static String getDefenderName(String[] players, String attackerName){
        
        if(players[0].equals(attackerName)){
            return players[1];
        }

        return players[0];
    }

    private static void showTurn(int i){
        System.out.printf("ターン %d: %n", i);
    }

    private static void showAttackText(String attackerName, String defenderName){
        
        System.out.printf("%s が %s を攻撃した. %n", attackerName, defenderName);
        System.out.println();
    }
}
