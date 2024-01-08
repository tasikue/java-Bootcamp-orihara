public class LabeledContinueStatement {
    public static void main(String[] args) {

        int COL = 7;
        int RAW = 3;

        for(int i=1; i < 10; i++ ){
            for(int j=1; j < 10; j++){
                if(j == RAW || i == COL) {
                    System.out.printf("@@@@@@@ ");
                    continue;
                }
                System.out.printf("%dX %d=%2d ", i, j, i*j);
            }
                System.out.println();
        }
    }
}
