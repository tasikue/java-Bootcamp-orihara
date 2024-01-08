/**
 * LeapYearChecker
 */
public class LeapYearChecker {

    public static void main(String[] args) {
        
        // 判定する年
        int point[] = {-45, 356, 1700, 2300, 2596};
        boolean isUru[] = new boolean[5];

        for (int i=0; i<point.length; i++) {
            isUru[i] = false;
            if(point[i] % 4 == 0){
                isUru[i] = true;
                if((point[i] % 100 == 0) && (point[i] % 400 != 0)){
                    isUru[i] = false;
                }
            }

            if(isUru[i]){
                System.out.printf("西暦 %4d 年は、 うるう年です. %n", point[i]);
            } else {
                System.out.printf("西暦 %4d 年は、 うるう年ではありません. %n", point[i]);
            }
        }
    }
}