public class BankAccount {
    
    private int id;
    private String name;
    private int age;
    private double balance;

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getBalance(){
        return balance;
    }
}
