/**
 * FigureManager
 */
public class FigureManager {

    public static void main(String[] args) {
        
        double triangleWidth = 10;
        double triangleHeight = 20;
        double triangleArea = Figure.calcTriangleArea(triangleWidth, triangleHeight);

        System.out.printf("底辺が %.1f cm で、高さが %.1f cm の三角形の面積 => %.1f\n", 
            triangleWidth,
            triangleHeight,
            triangleArea
        );
    }
}