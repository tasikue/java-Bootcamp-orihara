import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * CurrentDateTime
 */
public class CurrentDateTime {

    private static final String DATE_DISPLAY_PATTERN = 
        "yyyy 年 MM 月 dd 日 HH 時 mm 分";

    public static void main(String[] args) {
        
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = 
            DateTimeFormatter.ofPattern(DATE_DISPLAY_PATTERN);
        String formatted = current.format(formatter);

        System.out.printf("現在の日時: %s\n", formatted);
    }
}