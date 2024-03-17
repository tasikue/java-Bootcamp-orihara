/**
 * javabootcamp04-10
 * 課題の使用例と出力を試すメインクラス
 * @auther orihara
 * @version 1.1
 */

public class App {

    /**
     * mainメソッド
     * 課題テスト用
     * @param args
     */
    public static void main(String[] args) {
        
        // ★「〇番目」に半角と全角が混在してます
        //   動作確認ができるので問題は解くにないですが、
        //   プログラマーは半角と全角文字の違いには敏感なので
        //   仕事では注意を
        //課題1
        executeUsageExample1();
        System.out.println();
        
        //課題2
        executeUsageExample2();
        System.out.println();

        // 課題3
        executeUsageExample3();
        System.out.println();

        // 課題4
        executeUsageExample4();
    }

    /**
     * 課題1
     */
    private static void executeUsageExample1(){
        // Queue クラスを生成
        Queue queue = new Queue();

        // キューに追加する
        queue.push("１番目");
        queue.push("２番目");
        queue.push("３番目");

        // キューから取り出して表示する
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    /**
     * 課題2
     */
    private static void executeUsageExample2(){
        // Stack クラスを生成
        Stack stack = new Stack();

        // スタックに追加する
        stack.push("１番目");
        stack.push("２番目");
        stack.push("３番目");
        
        // スタックから取り出して表示する
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    /**
     * 課題3
     */
    private static void executeUsageExample3(){
        // RandomQueue クラスを生成
        RandomQueue queue = new RandomQueue();

        // キューに追加する
        queue.push("１番目");
        queue.push("２番目");
        queue.push("３番目");

        // キューから取り出して表示する
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    /**
     * 課題4
     */
    private static void executeUsageExample4(){
        // Queue クラスを生成
        Queue queue = new Queue();

        // キューに追加する
        queue.push("1 番目", 10);
        queue.push("2 番目", 10);
        queue.push("3 番目", 100);
        queue.push("4 番目", 50);

        // キューから取り出して表示する
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
