/*
 * メッセージを扱うクラス
 * 
 */

public class MessageText {

    public static void showPrologueText(int day){
        messageln("～プロローグ～");
        message("あなたは目が覚めたら無人島にいた。");
        message("目の前に1枚の手紙がある。");
        messageln("手紙にはこう書かれていた・・・");
        message("「%d 日間生き延びたら助けます」", day);
        message("");
        messageln("こうして無人島生活が始まった。");
    }

    public static void showGoodMorningText(int day, Player player){
        messageln("--- --- --- ---");
        message("%d 日目", day);
        message("あなたの体力: %d", player.getHp());
        message("残りヒント数: %d", player.getHintCount());
        message("");
        messageln("朝日が眩しい...");
        message("");
    }

    public static void showEatItemGetText(EatItem eatItem){
        messageln("今日も食べ物を探そう。。。。。。");
        message("%s を見つけた！", eatItem.getItemName());
        showEatItemStatusText(eatItem);
    }

    public static void showAskingEatText(EatItem eatItem){
        message("%s を食べてみますか？ (y: はい / n: いいえ / h: ヒント)", eatItem.getItemName());
    }

    public static void showEatItemNextGetText(EatItem eatItemNext){
        message("明日は %s が食べられる気がする...", eatItemNext.getItemName());
        showEatItemStatusText(eatItemNext);
        message("");
    }

    public static void showNotHasHintText(){
        messageln("明日はどんな日になるかわからない...");
    }

    public static void showDecideText(){
        message("決断を迫られている！");
    }

    private static void showEatItemStatusText(EatItem eatItem){
        message("危険度: %d ％", eatItem.getDangerLevel());
        message("回復量: %d", eatItem.getExpectedHeelingHP());
    }

    public static void showEatItemCanEatingText(EatItem eatItem){
        message("あなたは %s をおそるおそる食べた。。。。。。", eatItem.getItemName());
        messageln(".... ... ...");
        message("なんとか食べきれた！");
        messageln("お腹が膨れた");
    }

    public static void showEatItemCanNotEatingText(EatItem eatItem){
        message("あなたは %s をおそるおそる食べた。。。。。。", eatItem.getItemName());
        messageln(".... ... ...");
        messageln("... ... ... うっ！");
        messageln("視界が狭まる！");
        message("%s", eatItem.getCauseOfDeath());
    }

    public static void showYourDeadText(){
        message("あなたは死んでしまった！");
        message("");
    }

    public static void showEatItemNotEatingText(EatItem eatItem){
        message("あなたは %s をその辺に捨てた！", eatItem.getItemName());
        messageln("...お腹の音が鳴った");
    }

    public static void showGoodNightText(){
        messageln("本日も生き延びることができたようだ");
        messageln("助けはまだ来ない");
        message("");
        messageln("辺りが暗闇に包まれていく...");
    }

    public static void showHungryText(int hp){
        if(hp == 100){
            messageln("満腹で歩けない...");
        } else if(hp < 100 && 70 <= hp){
            messageln("しばらくは食べ物に困らなそうだ");
        } else if(hp < 70 && 30 <= hp){
            messageln("明日は食べ物があるだろうか...");
        } else if(hp < 30 && 0 < hp ){
            messageln("何か口に入れないと死んでしまいそうだ...!");
        } else {
            messageln("空腹で倒れた... ... ...");
        }
    }

    public static void showGameClearText(){
        messageln("本日も生き延びることができたようだ");
        message("なにやら音がする。。。。。。");
        messageln("助けが来た！");
        message("");
        messageln("あなたは無事、無人島から脱出した！!");
    }

    public static void showGameOverText(){
        message("--- 生存記録 ---");
    }

    public static void showHistoryText(EatItemHistory history){
        System.out.printf("%d 日目 → ", history.getDay());
        System.out.printf("HP: %d | ", history.getHp());
        System.out.printf("食べ物: %s | ", history.getEatItemName());
        System.out.printf("危険度: %d | ", history.getDangerLevel());
        if(history.getDoEat()){
            System.out.printf("食べた\n");
        } else {
            System.out.printf("食べなかった\n");
        }
    }

    private static void message(String text){
        System.out.println(text);
    }

    private static void messageln(String text){
        System.out.println(text);
        System.out.println();
    }

    private static void message(String text, int number){
        System.out.println(String.format(text, number));
    }
    
    private static void message(String text, String name){
        System.out.println(String.format(text, name));
    }
}
