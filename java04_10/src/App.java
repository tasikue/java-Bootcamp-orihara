/*
 * javabootcamp04-10
 * 課題の使用例と出力を試すメインクラス
 * 
 */

public class App {

    public static void main(String[] args) {
        
        //showProblemOne();
        //showProblemTwe();
        showProblemThree();
        //showProblemFour();
    }

    private static void showProblemOne(){
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

    private static void showProblemTwe(){
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

    private static void showProblemThree(){
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

    private static void showProblemFour(){
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
