import java.util.Random;

public class SlimeAttacker {

    public static void main(String[] args) {

        Slime slime = new Slime("メタルスライム", 12);
        int cntTurn = 0;
        
        while (slime.isLive()) {

            cntTurn++;
            System.out.printf("%d ターン: %n", cntTurn);

            slime.recieveBlows();

            if (slime.isDead()) {
                System.out.printf(
                    "%s は死にました.  %n", slime.name
                );
            }

            System.out.println();
        }
    }
}

class Slime {

    Random rand = new Random();
    
    public String name;
    public int hp;
    
    public Slime(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }
    
    public void recieveBlows() {
        
        System.out.printf("%s は殴られた. %n", this.name);
        
        int damage = this.rand.nextInt(10);
        this.hp = Math.max(0, this.hp - damage);
        
        System.out.printf(
            " => %s は %d のダメージを受けた. %n", this.name, damage
        );
        
        System.out.printf(" => HP: %d %n", this.hp);
    }

    public boolean isLive(){
        return this.hp > 0;
    }

    public boolean isDead(){
        return this.hp <= 0;
    }
}