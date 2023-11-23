import java.util.Random;

public class HpChecker {
    public static void main(String[] args) {
        
        Random ran = new Random();
        HpChecker dead = new HpChecker();

        int HP = ran.nextInt(10);
        boolean is = dead.isDead(HP);

        do {
            HP = ran.nextInt(10);
            is = dead.isDead(HP);

            System.out.printf("HP => %d: ", HP);
            if(is){
                System.out.println("死んでます. ");
            } else {
                System.out.println("生きてます. ");
            }
        } while (!is);
    }

    public boolean isDead(int life){
        if(life == 0){
            return true;
        } else {
            return false;
        }
    }
}
