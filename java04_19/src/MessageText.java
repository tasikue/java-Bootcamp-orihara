/*
 * メッセージを扱うクラス
 * 
 */

public class MessageText {

    public static void showPrologue(){
        messageln("～プロローグ～");
        message("あなたは目が覚めたら無人島にいた。");
        message("目の前に1枚の手紙がある。");
        messageln("手紙にはこう書かれていた・・・");
        messageln("「３０日間生き延びたら助けます」");
        messageln("こうして無人島生活が始まった。");
    }

    public static void showStartDay(int day, Player player){
        messageln("--- --- --- ---");
        message("%d 日目", day);
        message("あなたの体力: %d", player.getHp());
        message("残りヒント数: %d", player.getHintCount());
        message("");
    }

    public static void showEatItemGet(){
        messageln("今日も食べ物を探そう。。。。。。");
        
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
    
}
