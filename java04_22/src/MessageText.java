import java.util.List;
/**
 * メッセージテキストを管理するためのクラス
 * @author orihara
 * @version 1.0
 */
public class MessageText {
    
    /** プロローグテキスト */
    public static void showPrologeText(){
        message("--- 遊び方 ---");
        messageln("あなたは 最強のポ◯モンマスターを 目指しています。");
        messageln("１０匹のモンスターが 次々と現れてきますので 捕獲玉を使って 捕獲しよう！");
        messageln("モンスターを 捕獲できれば モンスターごとに設定された ポイントを獲得できます。");
        message("３種類ある捕獲玉を うまく使って 高得点を目指そう！");
        messageln("--- --- --- --- --- --- --- --- --- ---");
    }

    /** スタンバイフェイズ */
    public static void showStanbyPhaseText(){
        messageln("あなたは 草むらに 繰り出した ！");
        messageln("ガサゴソ....ガサゴソ...ガサゴソ.......");
        messageln("... ... ... !!");
        messageln("草むらから 何かが 飛び出した！");
    }

    /** バトルフェイズ1 */
    public static void showBattlePhaseOneText(CaptureBallList ballList, Monster monster){
        message("%s が現れた！", monster.getName());
        showStatusDisplay(monster);
        message("あなたは どうする？(数字を選択してください)");
        showCommandSelectText(ballList, monster);
    }

    /** バトルフェイズ2 */
    public static void showBattlePhaseTweText(CaptureBall ball){
        message("");
        message("あなたは %s を投げた !", ball.getName());
        message("... !");
        message("... ... !!");
        messageln("... ... ... !!!");
    }

    /** バトルフェイズ2: 捕獲成功 */
    public static void showBattlePhaseTweSuccessText(Monster monster){
        messageln("おめでとう ! %s を捕獲した !", monster.getName());
        messageln("やったね !");
        messageln("");
    }

    /** バトルフェイズ2: 捕獲失敗 */
    public static void showBattlePhaseTweFailureText(Monster monster){
        message("ああっ！ %s は捕獲玉から出てしまった !", monster.getName());
        message("%s は様子を見ている ...!", monster.getName());
        messageln("--- --- --- ---");
    }

    /** バトルフェイズ2: 捕獲失敗から次へ続く */
    public static void showBattlePhaseTweFailureNextText(CaptureBallList ballList,Monster monster){
        message("次は どうする ?(数字を選択してください)");
        showCommandSelectText(ballList, monster);
    }

    /** バトルフェイズ: 逃げるテキスト */
    public static void showBattlePhaseRunAweyText(){
        messageln("あなたは 逃げ出した !");
    }

    /** バトルフェイズ3 */
    public static void showBattlePhaseThreeText(){
        message("次のモンスターを探そう !");
        messageln("--- --- --- --- --- --- --- --- --- ---");
    }

    /** ボールがなく終了したとき */
    public static void showBattleEndNothaveBallText(){
        messageln("手元には 投げれるボールが ない");
    }

    /** 回数で終了したとき */
    public static void showBattleEndNotPhaseBallText(){
        message("もう日が 暮れてきた...");
        messageln("そろそろ 帰らなきゃ !");
    }

    /** 捕獲したモンスターの一覧表示 */
    public static void showCapturedMonsterList(List<Monster> monsterList){
        message("--- --- --- --- --- --- --- --- --- ---");
        messageln("今回捕獲したモンスター一覧");
        
        // 捕獲できなかった場合
        if(monsterList.isEmpty()){
            messageln("なにも捕獲できなかった");
        }

        // 名前の表示とポイント計算
        int totalPoint = 0;
        for(Monster monster : monsterList){
            System.out.printf("%s: %d ポイント \n", monster.getName(), monster.calcCaputuredPoint());
            totalPoint += monster.calcCaputuredPoint();
        }
        messageln("");
        message("合計獲得ポイント: %d ポイント", totalPoint);
    }

    /** 
     * モンスターのステータス表示 
     * 実際HPは減ることはないので見かけ表示
     */
    private static void showStatusDisplay(Monster monster){
        message("----------------------------------");
        System.out.printf("%s | 攻撃力: %d | 防御力: %d \n", 
                            monster.getName(),
                            monster.getPowerValue(),
                            monster.getDefenceValue());
        System.out.printf("HP( %d / %d ): ■■■■■■■■■■■■■■■ \n", 
                            monster.getHpValue(), 
                            monster.getHpValue());
         messageln("-----------------------------------");
    }

    /** 
     * コマンド表示
     * @param index インデックス
     * @param ball 指定する捕獲玉
     * @param monster ターゲットになるモンスター
     */
    private static void showCommandDisplay(int index, CaptureBall ball, Monster monster){
        final int CAPTURE_RATE_MAX = 100;
        int captureRate = monster.getCaptureRate() + ball.getCorrectValue();

        // 捕獲成功率が100%以上の時、100%に丸める
        if(captureRate > CAPTURE_RATE_MAX){
            captureRate = CAPTURE_RATE_MAX;
        }
        System.out.printf("%d: %s を使う(残り %d個。捕獲成功率: %d％) \n", index, ball.getName(), ball.getCount(), captureRate);
    }

    /**
     * コマンド選択肢を全部表示する
     * @param ballList ボールが収納されているリスト
     * @param monster ターゲットにしているモンスター
     */
    private static void showCommandSelectText(CaptureBallList ballList, Monster monster){
        int index=0;
        while(index < ballList.getListLength()){
            showCommandDisplay(index+1, ballList.getCaptureBall(index), monster);
            index++;
        }
        message("%d: モンスターを 見逃す", ++index);
    }

    /** メッセージ表示（改行あり） */
    private static void messageln(String text){
        System.out.println(text);
        System.out.println();
    }

    /** メッセージ表示（改行なし） */
    private static void message(String text){
        System.out.println(text);
    }

    /** 
     * メッセージ表示（改行あり）
     * @param text 表示するテキスト
     * @param name テキストに組み込む文字列の変数
     */
    private static void messageln(String text, String name){
        System.out.printf(text +"\n", name);
        System.out.println();
    }
    /** メッセージ表示（改行なし）*/
    private static void message(String text, String name){
        System.out.printf(text +"\n", name);
    }
    /** メッセージ表示（改行なし）*/
    private static void message(String text, int index){
        System.out.printf(text +"\n", index);
    }
}
