package advanced.abstracts.animal.entity;

public class Rabbit extends Animal{

    public Rabbit (String name, boolean isMale){
        super(name, isMale, "草食");
    }

    @Override
    public void bark(){
        System.out.println("みゅー みゅー ........");
    }

    @Override
    public void eat(){
        super.eat();
        System.out.println("草を食べた ........");
    }
}
