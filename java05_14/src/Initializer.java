public class Initializer {

    private String name;
    private static int staticCounter;
    private int instanceCounter;
    private int id;

    static {
        showStaticInitializerAction();
    }

    {
        incrementStaticCounter();
        incrementInstanceCounter();
        assignId();
    }

    public Initializer(String name){
        this.name = name;
    }

    private static void showStaticInitializerAction(){
        System.out.println("Static 初期化ブロックが実行されました");
    }

    private void assignId(){
        this.id = staticCounter;
    }

    private static void incrementStaticCounter(){
        staticCounter++;
    }

    private void incrementInstanceCounter(){
        instanceCounter++;
    }


    public void showCounterValue(){
        System.out.format(
            "[id] %d, [name] %s, [staticCounter] %d, [instanceCounter] %d %n",
            this.id, this.name, staticCounter, this.instanceCounter
        );
    }
}
