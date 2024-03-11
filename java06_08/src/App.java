import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        
        UnaryOperator<String> pickOutFirstChar = s -> s.substring(0, 2);
        UnaryOperator<String> duplicateWord = s -> s+s;

        String afterProcessed = applyFunctions(
            "山本一郎", pickOutFirstChar, duplicateWord);

            System.out.println(afterProcessed);
    }

    @SafeVarargs
    private static String applyFunctions(
            String s, UnaryOperator<String>... functions){

        String ret = s;
        for(UnaryOperator<String> function : functions){
            ret = function.apply(ret);
        }

        return ret;
    }
}
