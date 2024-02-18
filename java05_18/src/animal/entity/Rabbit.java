package animal.entity;

public class Rabbit extends Animal {

    public Rabbit(
            String name, Gender gender) {
        super(name, gender,  Animal.FeedingType.CARNI);
    }

    @Override
    public void bark() {
        System.out.println("みゅー みゅー ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("草を食べた ........");
    }
}