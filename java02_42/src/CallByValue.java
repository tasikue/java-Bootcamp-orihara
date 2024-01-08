public class CallByValue {
    public static void main(String[] args) {

        int foo = 128;

        deliver(foo);
        System.out.printf("int foo => %d %n", foo);
    }

    private static void deliver(int bar) {
        
        bar = 256;
        System.out.printf("int bar => %d %n", bar);
    }
}