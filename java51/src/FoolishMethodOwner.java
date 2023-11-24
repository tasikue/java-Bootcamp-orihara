public class FoolishMethodOwner {

    private final int[] CONFIGURATED_NUMS = {
        6, 11, 25, 41, 52,
    };

    private boolean isLucky = false;
    public static void main(String[] args) {

        FoolishMethodOwner app = new FoolishMethodOwner();
        int numsLength = app.CONFIGURATED_NUMS.length;
        
        for (int i = 0; i < numsLength; i++) {
            int number = app.generateNumber(i);
            app.setIsLucky(number);
            app.showIsLucky(number);
        }
    }

    private int generateNumber(int index) {
        int num = CONFIGURATED_NUMS[index];
        return num;
    }

    private void setIsLucky(int num){
        if (num % 2 == 0) {
            this.isLucky = true;
        } else {
            this.isLucky = false;
        }
    }

    private void showIsLucky(int num) {
        if (this.isLucky) {
            System.out.printf("%2d => 幸運です. %n", num);
            return;
        }
        System.out.printf(
            "%2d => 幸運ではありません. %n", num
        );
    }
}