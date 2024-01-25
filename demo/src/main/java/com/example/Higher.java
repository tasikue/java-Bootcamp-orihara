package com.example;

public class Higher {

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
}
