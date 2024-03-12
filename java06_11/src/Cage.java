import java.util.ArrayList;
import java.util.List;

public class Cage<T extends Bird> {
    
    private List<T> birdList;

    public Cage(){
        this.birdList = new ArrayList<>();
    }

    public void addBird(T bird){
        this.birdList.add(bird);
    }

    public List<T> getBirds(){
        return this.birdList;
    }
}
