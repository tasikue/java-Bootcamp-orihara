import java.util.List;

public class Loggers {

    static final String QUOTE_CURSOR = ">";

    public static void showContents(List<String> readLines){

        for (String line : readLines) {
            System.out.printf("%s %s %n", QUOTE_CURSOR, line);
        }
    }

    public static void showLog(String message){
        System.out.println(message);
    }
}
