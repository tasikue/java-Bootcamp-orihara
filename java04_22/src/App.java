/**
 * すべてを動作するメインクラス
 */
public class App {

    /**
     * メインクラス
     * @param args 使用しない
     */
    public static void main(String[] args) {

        MonsterList monsterList = new MonsterList();
        
        MessageText.showPrologeText();
        MessageText.showStanbyPhaseText();
        MessageText.showBattlePhaseText(monsterList.getRandomMonster());
    }
}
