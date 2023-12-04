/**
 * Organizer
 */
public class Organizer {

    public static void main(String[] args) {

        final int TOTAL_PRICE = 12000;
        final int NUMBER_OF_MALE = 3;
        final int NUMBER_OF_FEMALE = 3;

        int totalPrice = TOTAL_PRICE;
        int numberOfMale = NUMBER_OF_MALE;
        int numberOfFemale = NUMBER_OF_FEMALE;

        // 課題1
        PerPersonAmount(totalPrice, numberOfMale, numberOfFemale);
        System.out.println();
    
        // 課題2
        PerPersonAmountMaleMany(totalPrice, numberOfMale, numberOfFemale);
    }

    private static void PerPersonAmount(int totalPrice, int numberOfMale, int numberOfFemal){
        
        int amountOfOne = totalPrice / (numberOfMale + numberOfFemal);

        System.out.printf("男性: %d 円\n", amountOfOne);
        System.out.printf("女性: %d 円\n", amountOfOne);
    }

    private static void PerPersonAmountMaleMany(int totalPrice, int numberOfMale, int numberOfFemal){

        final int MARGIN = 1000;

        int amountOfFemale = (totalPrice - MARGIN * numberOfMale) / (numberOfMale + numberOfFemal);
        int amountOfMale = amountOfFemale + MARGIN;

        System.out.printf("男性: %d 円\n", amountOfMale);
        System.out.printf("女性: %d 円\n", amountOfFemale);
    }
}