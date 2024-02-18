package animal.entity;

public class Cat extends Animal {

    public Cat(
            String name, Gender gender) {
                super(name, gender, FeedingType.CARNI);
    }

    @Override
    public void bark() {
        System.out.println("にゃあ にゃあ ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("魚を食べた ........");
    }
}