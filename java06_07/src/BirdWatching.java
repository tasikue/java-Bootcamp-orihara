import static util.Logger.LogType.ERROR;

import entity.Eagle;
import entity.Pigeon;
import entity.base.Bird;
import exception.AppException;
import util.Logger;

public class BirdWatching {

    public static void main(String[] args) {

        boolean isNeedToValidPigeon = true;
        boolean isNeedToConvertToPigeon = false;

        BirdWatching app = new BirdWatching();
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();
        
        isNeedToValidPigeon = false;
        isNeedToConvertToPigeon = true;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
        System.out.println();
        
        isNeedToConvertToPigeon = false;
        app.execute(
                isNeedToValidPigeon,
                isNeedToConvertToPigeon);
    }

    private void execute(
            boolean isNeedToValidPigeon,
            boolean isNeedToConvertToPigeon) {
        
        Bird eagle = new Eagle("オジロワシ");
        Bird pigeon = new Pigeon(null);
        
        try {
            eagle.fly();
            
            if (isNeedToValidPigeon) {
                pigeon.fly();
                pigeon.isEmptyName();
            }
            
            if (isNeedToConvertToPigeon) {
                Bird convertedPigeon = Bird.convertToPigeon(eagle);
                convertedPigeon.fly();
            }
        } catch (AppException e) {
            Logger.log(ERROR, e);
        }
    }
}