import java.util.Scanner;
import java.util.Random;

/*
 * メイン
 */


public class NameBattler {

    final static int NUMBER_OF_PLAYER = 2;
    final static int MAX_DAMAGE = 3;
    final static int MIN_DAMAGE = 1;

    static Scanner scan= new Scanner(System.in);
    static Random ram = new Random();

    public static void main(String[] args) throws Exception {

        String[] playerNamelist = new String[NUMBER_OF_PLAYER];
        
        // 全プレイヤー名設定
        for(int i=0; i<NUMBER_OF_PLAYER; i++){
            playerNamelist[i] = inputNameText(i+1);
        }

        // プレイヤーの作成
        CharacterSetting Player1 = new CharacterSetting(playerNamelist[0]);
        CharacterSetting Player2 = new CharacterSetting(playerNamelist[1]);

        showBattleStartText();
        playMainBattle(Player1, Player2);
        showBattleEndText(Player1, Player2);
    }

    static void playMainBattle(CharacterSetting PlayerA, CharacterSetting PlayerB){

        while(!PlayerA.getIsDeath() || !PlayerB.getIsDeath()){
            // player1 -> player2
            showBattleDamegeCalc(PlayerA, PlayerB);
           
            if(PlayerB.getPlayerHp() <= 0){
                PlayerB.onIsDeath();
                return;
            }

            // player 2 -> player1
            showBattleDamegeCalc(PlayerB, PlayerA);

            if(PlayerA.getPlayerHp() <= 0){
                PlayerA.onIsDeath();
                return;
            }

            showTurnChangeText(PlayerA, PlayerB);
        }
    }

    static String inputNameText(int playerNumber){

        System.out.printf("プレイヤー %d の名前を入力してください: ", playerNumber);
        String playerName = scan.nextLine();

        return playerName;
    }

    private static void showBattleStartText(){
        System.out.println();
        System.out.println("=== バトル開始 ===");
    }

    private static void showBattleDamegeCalc(CharacterSetting PlayerA, CharacterSetting PlayerB){

        int damage = ram.nextInt(MAX_DAMAGE) + MIN_DAMAGE;
        PlayerB.decreasePlayerHp(damage);

        System.out.printf("%sの攻撃！\n", PlayerA.getPlayerName());        
        System.out.printf("%sに %d のダメージ！\n", PlayerB.getPlayerName(), damage);
    }

    private static void showTurnChangeText(CharacterSetting PlayerA, CharacterSetting PlayerB){
        System.out.println();
        System.out.println("-次のターン-");
        System.out.printf("プレイヤー 1: %s(HP %d)\n", PlayerA.getPlayerName(), PlayerA.getPlayerHp());
        System.out.printf("プレイヤー 2: %s(HP %d)\n", PlayerB.getPlayerName(), PlayerB.getPlayerHp());
        System.out.println();
        System.out.println("---");
        System.out.println();
    }

    private static void showBattleEndText(CharacterSetting PlayerA, CharacterSetting PlayerB){

        if(PlayerA.getIsDeath()){
            System.out.printf("%s は力尽きた…\n", PlayerA.getPlayerName());
            System.out.printf("%s の勝利！！\n", PlayerB.getPlayerName());
        }

        if(PlayerB.getIsDeath()){
            System.out.printf("%s は力尽きた…\n", PlayerB.getPlayerName());
            System.out.printf("%s の勝利！！\n", PlayerA.getPlayerName());
        }
    }
}
