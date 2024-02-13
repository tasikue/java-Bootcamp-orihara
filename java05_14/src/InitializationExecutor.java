public class InitializationExecutor {

    public static void main(String[] args) {

        Initializer testInit = new Initializer("事前テスト");
        
        testInit.showCounterValue();
        System.out.println();
        
        Initializer[] inits = {
                new Initializer("一郎"),
                new Initializer("次郎"),
                new Initializer("三郎"),
            };
        
        for (Initializer init : inits) {
            init.showCounterValue();
        
        }
        
        System.out.println();
        testInit = new Initializer("中間テスト");
        testInit.showCounterValue();
        System.out.println();
        
        for (Initializer init : inits) {
            init.showCounterValue();
        }
    }
}