/**
 * MultiDemendionalArray
 */
public class MultiDemendionalArray {

    public static void main(String[] args) {
        
        int HORIZONTAL_INDEX = 2;
        int VERTICAL_INDEX = 1;

        int[][] dimArray = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};

        System.out.printf("水平方向(X)に %d, 垂直方向(Y)に %d のインデックスにある値 => %d", 
            HORIZONTAL_INDEX, VERTICAL_INDEX, dimArray[VERTICAL_INDEX][HORIZONTAL_INDEX]);
    }
}