
import animal.entity.Animal;
import animal.entity.Barkable;
import animal.entity.Cat;
import animal.entity.Rabbit;

public class PetShop {
    
    public static void main(String[] args) {
        Animal[] pets = {
                new Rabbit(
                        "スキウサギ",
                        Animal.Gender.WOMAN
                    ),
                new Cat(
                        "どらねこ",
                        Animal.Gender.MAN
                    ),
            };
        for (Animal pet : pets) {
            System.out.println(pet.toString());
            pet.eat();
            pet.bark();
            System.out.println();
        }
        pets[0].changeName("ツキウサギ");
        System.out.println(pets[0].toString());
        pets[0].eat();
        Barkable rabbit = pets[0];
        rabbit.bark();
    }
}