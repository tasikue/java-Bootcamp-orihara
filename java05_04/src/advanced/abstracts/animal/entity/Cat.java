package advanced.abstracts.animal.entity;

public class Cat extends Animal{
    
    public Cat(String name,boolean isMale){
        super(name, isMale, "肉食");
    }

    @Override
    public void bark(){
        System.out.println("にゃあ にゃあ ........");
    }

    @Override
    public void eat(){
        super.eat();
        System.out.println("魚をたべた ........");
    }
}
