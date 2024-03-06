public class NullPointerDemo {

    public static void main(String args[]) {

        try {
            generateNullPointerDemo();
        } catch (NullPointerException e) {
            System.out.format("再キャッチ: %s %n", e);
        }
    }

    static void generateNullPointerDemo() {
        try {
            throw new NullPointerException("demo");
        } catch (NullPointerException e)    {
            System.out.println("generateNullPointerDemo の中でキャッチされた");
            throw e;
        }
    }
}