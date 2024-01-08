import java.util.List;
import java.util.ArrayList;

/**
 * DogOwner 
 */
public class DogOwner  {

    public static void main(String[] args) {

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("秋田賢", 7, "秋田犬"));
        dogs.add(new Dog("山本一郎", 1, "プードル"));
        dogs.add(new Dog("山本太郎", 2, "チワワ"));
    
        for(Dog dog : dogs){
            dog.showDetails();
        }
    }
}