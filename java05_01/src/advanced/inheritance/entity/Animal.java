package advanced.inheritance.entity;

public class Animal {

    private String name;
    
    public void eat() {

        System.out.println(
              "[Animal] 食べます .........."
          );
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
}