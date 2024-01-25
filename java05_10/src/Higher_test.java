import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Higher_test {

    public static void main(String[] args) {
        int a = 25;
        int b = -25;
        int higherNum = higher(a, b);
        System.out.printf(
               "より大きい数字は %d です. %n",
               higherNum
            );
    }

    public static int higher(int x, int y) {
        if (x > y) return x;
        return y;
    }
    
    @Test
    public void testHigher() {
        assertEquals(25, higher(23, 25));
        assertEquals(5, higher(3, 5));
    }
}