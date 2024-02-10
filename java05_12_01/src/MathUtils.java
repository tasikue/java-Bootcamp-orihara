/**
 * MathUtils
 */
public class MathUtils {

    public static long addLong(Long i, Long j){
        return i+j;
    }

    public static int addInts(int i, int... intArgs){
        
        int sum = i;
        for(int element : intArgs){
            sum+= element;
        }

        return sum;
    }
}