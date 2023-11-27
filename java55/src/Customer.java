/**
 * Customer
 */
public class Customer {

    private String name;
    private Payment payment;

    public Customer(String name, int fee) { 
        this.name = name;
        this.payment = new Payment(fee);
    }

    public void pay(){
        this.payment.pay();
    }

    public void showIsPaid(){
        if (this.payment.isCompleted()) {
            System.out.printf(
                "%s さんは %d 円支払い済みです. %n"
                ,this.name , this.payment.getAmount()
            );
            return;
        }

        System.out.printf(
            "%s さんに %d 円請求中です. %n"
            ,this.name , this.payment.getAmount()
        );
    }
}