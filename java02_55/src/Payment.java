/**
 * Payment
 */
public class Payment {

    private int amount;
    private boolean isCompleted;

    public Payment(int fee){
        this.amount = fee;
        this.isCompleted = false;
    }

    public void pay(){
        this.isCompleted = true;
    }

    public int getAmount(){
        return this.amount;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }
}