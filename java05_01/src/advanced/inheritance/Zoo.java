package advanced.inheritance;

import advanced.inheritance.entity.Dog;

public class Zoo {

    public static void main(String[] args) {

        Dog labrador = new Dog();
        
        labrador.setName("ポチ");
        labrador.display();
        labrador.eat();
  }
}