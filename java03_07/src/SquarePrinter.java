import java.util.Scanner;

public class SquarePrinter {

    private static Scanner stdin = new Scanner(System.in);
    private static final int MAX_WIDTH = 9;
    
    public static void main(String[] args) {

        String strCharInput = "";
        
        while (!isInputOneChar(strCharInput)) {
            strCharInput = inputLine();
            showNotInputOneChar(strCharInput);
        }

        String strWidthInput = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.printf(
                "幅（1 ～ %d）を入力してください: ",
                MAX_WIDTH
            );
            strWidthInput = stdin.nextLine();
            isValid = isWidthValid(strWidthInput);
        }

        printSquare(strCharInput, strWidthInput);
        stdin.close();
    }

    private static String inputLine(){

        System.out.print("一文字入力してください: ");
        String input = stdin.nextLine();
        
        return input;
    }

    private static boolean isInputOneChar(String str){
        if(str.length() != 1){
            return false;
        }
        return true;
    }

    private static void showNotInputOneChar(String str){
        if (!isInputOneChar(str)) {
                System.out.println(" => 一文字ではありません.");
            }
            System.out.println();
    }

    private static boolean isWidthValid(String str){

        int intWidth = 0;

        try {
            intWidth = Integer.parseInt(str);

        } catch (NumberFormatException e) {
            showNotWidthValid();
            return false;
        }
        if (intWidth <= 0 || intWidth > MAX_WIDTH) {
            showNotWidthValid();
            return false;
        }

        return true;
    }

    private static void showNotWidthValid(){
        System.out.println(" => 値が不正です.");
        System.out.println();
    }

    private static void printSquare(String strChar, String strWidth){

        int intWidth = Integer.parseInt(strWidth);
        char charToDraw = strChar.charAt(0);

        System.out.println();
        for (int i = 0; i < intWidth; i++) {
            for (int j = 0; j < intWidth; j++) {
                System.out.print(charToDraw);
            }
            System.out.println();
        }
    }
}