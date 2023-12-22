/**
 * StatusChack
 * ※本課題に関係ないデバック用です。
 * 
 */
public class StatusChack {

    public static void statusChack(CharacterSetting PlayerA, CharacterSetting PlayerB){
        System.out.println("Player 1: " + PlayerA.getPlayerName());
        System.out.println("HP: " + PlayerA.getPlayerHp());
        System.out.println("STR: " + PlayerA.getPlayerStr());
        System.out.println("DEF :" + PlayerA.getPlayerDef());
        System.out.println("LUCK :" + PlayerA.getPlayerLuck());
        System.out.println("Player 2: " + PlayerB.getPlayerName());
        System.out.println("HP: " + PlayerB.getPlayerHp());
        System.out.println("STR: " + PlayerB.getPlayerStr());
        System.out.println("DEF :" + PlayerB.getPlayerDef());
        System.out.println("LUCK :" + PlayerB.getPlayerLuck());
    }
}