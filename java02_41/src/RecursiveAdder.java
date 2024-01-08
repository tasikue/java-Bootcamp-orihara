public class RecursiveAdder {
    public static void main(String[] args) {
        int num = 3;
        System.out.printf(
            "1 ～ %d の整数を足した結果 => %d %n"
            , num, add(num)
        );
      }
      public static int add(int num) {
        if (num <= 0) return 0;
        return num + add(num - 1);
      }
}