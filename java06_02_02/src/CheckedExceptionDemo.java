import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionDemo {
    private static final String MESSAGE_FORMAT_FOR_OCCURED_EXCEPTION = "%s が発生しました %n";
    private static final String MESSAGE_FOR_EXTENDS_THROWABLE = "Throwable を継承しています";
    private static final String MESSAGE_FOR_NOT_EXTENDS_THROWABLE = "Throwable を継承していません";
    private static final String MESSAGE_FOR_UNCHECKED_EXCEPTION = "非チェック例外です";
    private static final String MESSAGE_FOR_NOT_UNCHECKED_EXCEPTION = "非チェック例外ではありません";
    private static final String TARGET_FOR_PARSE_TO_INT = "b";

    public static void main(String[] args) {
        // ここに処理を書く

        String numStr = TARGET_FOR_PARSE_TO_INT;

        try {
            Integer.parseInt(numStr);

        } catch (NumberFormatException e) {
            showIsUncheckedException(e);
            showOccuredException(e);
            showIsExtendsThrowable(e);
        }
    }

    private static void showOccuredException(Exception e) {
        System.out.format(MESSAGE_FORMAT_FOR_OCCURED_EXCEPTION,
                e.getClass().getSimpleName());
    }

    private static void showIsExtendsThrowable(Exception e) {
        if (e instanceof Throwable) {
            System.out.println(MESSAGE_FOR_EXTENDS_THROWABLE);
            return;
        }
        System.out.println(MESSAGE_FOR_NOT_EXTENDS_THROWABLE);
    }

    private static void showIsUncheckedException(Exception e) {
        if (e instanceof RuntimeException) {
            System.out.println(MESSAGE_FOR_UNCHECKED_EXCEPTION);
            return;
        }
        show(MESSAGE_FOR_NOT_UNCHECKED_EXCEPTION);
    }

    private static void show(String message) {
        System.out.println(message);
    }
}