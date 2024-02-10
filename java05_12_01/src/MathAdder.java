public class MathAdder {
    
    public static void main(String[] args) {
        
        long resultAddLong = MathUtils.addLong(100L, 20L);
        int resultAddInts = MathUtils.addInts(9, 1, 22, 72, 5, 6);
    
        System.out.format("addLong メソッドの結果: %d %n", resultAddLong);
        System.out.format("addInts メソッドの結果: %d %n", resultAddInts);
    }
}
