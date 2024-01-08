/**
 * HouseKeeper
 */
public class HouseKeeper {

    public static void main(String[] args) {
        
        House house = new House("山本一郎", "赤", "愛知県名古屋市中区伏見 3-4-5");
    
        house.closeDoor();
        house.openDoor();
        house.showDetails();
    }
}