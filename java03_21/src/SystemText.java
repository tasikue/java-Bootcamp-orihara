public class SystemText {
    
    public static void showBattleStartText(){
        System.out.println();
        System.out.println("=== バトル開始 ===");
    }

    public static void showTurnChangeText(CharacterSetting PlayerA, CharacterSetting PlayerB){
        System.out.println();
        System.out.println("-次のターン-");
        System.out.printf("プレイヤー 1: %s(HP %d)\n", PlayerA.getPlayerName(), PlayerA.getPlayerHp());
        System.out.printf("プレイヤー 2: %s(HP %d)\n", PlayerB.getPlayerName(), PlayerB.getPlayerHp());
        System.out.println();
        System.out.println("---");
        System.out.println();
    }

    public static void showBattleEndText(CharacterSetting PlayerA, CharacterSetting PlayerB){

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
