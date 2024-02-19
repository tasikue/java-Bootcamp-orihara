import java.util.Scanner;
import java.util.Random;

/*
 * メイン
 */

public class NameBattler {

    final static int NUMBER_OF_PLAYER = 2;
    final static int MAX_HUSH = 256;

    // 日本語入力文字化け対策 Shift-JIS or UTF-8
    static Scanner scan= new Scanner(System.in, "Shift-JIS");
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

        StatusChack.statusChack(Player1, Player2);

        SystemText.showBattleStartText();
        playMainBattle(Player1, Player2);
        SystemText.showBattleEndText(Player1, Player2);
    }

    static void playMainBattle(CharacterSetting PlayerA, CharacterSetting PlayerB){

        while(!PlayerA.getIsDeath() || !PlayerB.getIsDeath()){
            // player1 -> player2
            showBattleDamege(PlayerA, PlayerB);
           
            if(PlayerB.getPlayerHp() <= 0){
                PlayerB.onIsDeath();
                return;
            }

            // player 2 -> player1
            showBattleDamege(PlayerB, PlayerA);

            if(PlayerA.getPlayerHp() <= 0){
                PlayerA.onIsDeath();
                return;
            }

            SystemText.showTurnChangeText(PlayerA, PlayerB);
        }
    }

    static String inputNameText(int playerNumber){

        System.out.printf("プレイヤー %d の名前を入力してください: ", playerNumber);
        String playerName = scan.nextLine();

        return playerName;
    }

    private static boolean isLuck(CharacterSetting Player){

        // 乱数0-255
        int dice = ram.nextInt(MAX_HUSH);
        return Player.getPlayerLuck() - dice >= 0;
    }

    private static int getDamageCalc(CharacterSetting PlayerA, CharacterSetting PlayerB){

        int attackDamage = PlayerA.getPlayerStr() - PlayerB.getPlayerDef();
        
        // ダメージがマイナスになる場合
        if(attackDamage < 0){
            attackDamage = 1;
        }

        // 乱数0-attack
        return ram.nextInt(attackDamage);
    }

    private static void showBattleDamege(CharacterSetting PlayerA, CharacterSetting PlayerB){

        int damage = getDamageCalc(PlayerA, PlayerB);
        System.out.printf("%sの攻撃！\n", PlayerA.getPlayerName()); 

        // 会心の一撃
        if(isLuck(PlayerA)){
            damage = PlayerA.getPlayerStr();
            System.out.println("会心の一撃！");
        }

        PlayerB.decreasePlayerHp(damage);

        if(damage == 0){
            System.out.println("攻撃がミス");
            return;
        }
        System.out.printf("%sに %d のダメージ！\n", PlayerB.getPlayerName(), damage);
    }
}
