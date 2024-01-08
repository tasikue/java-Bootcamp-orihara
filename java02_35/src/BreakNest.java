public class BreakNest {
    public static void main(String[] args) {

        int MAX_ANSWER = 20;

        for(int i=1; i < 10; i++ ){
            for(int j=1; j < 10; j++){
                if(i * j >= MAX_ANSWER) {
                    continue;
                }
                System.out.printf("%dX %d=%2d ", i, j, i*j);
            }
                System.out.println();
        }
    }

    // 解答例ではbreakを使ってる
}
