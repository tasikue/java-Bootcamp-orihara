package advanced.override.entity;

public class Dog extends Animal {
    
    public void bark(){
        System.out.println(
              "[Dog] わん わん .........."
          );
    }

    @Override
    public void eat(){
        System.out.println(
              "[Dog] 食べます .........."
          );
    }
}
