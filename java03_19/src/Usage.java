import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class Usage {
    public static void createUsageContent(List<String> lines, String name, int usageContent){
        createUsageHeader(lines);
        createUsageOutputDateTime(lines);
        createUsageDetails(lines, name, usageContent);
    }


    private static void createUsageHeader(List<String> lines){
        lines.add("利用回数");
        lines.add("-----");
    }

    private static void createUsageOutputDateTime(List<String> lines){
        
        final LocalDateTime NOW = LocalDateTime.now();
        
        lines.add(
                String.format(
                        " - 出力日時: %s-%s-%s(%s) %s:%s:%s",
                        NOW.getYear(),
                        NOW.getMonth(),
                        NOW.getDayOfMonth(),
                        NOW.getDayOfWeek()
                                .getDisplayName(
                                    TextStyle.SHORT, Locale.JAPANESE
                                ),
                        NOW.getHour(),
                        NOW.getMinute(),
                        NOW.getSecond()));
    }

    private static void createUsageDetails(List<String> lines, String name, int usageContent){
        lines.add(
                String.format(" - 氏名: %s", name));
        lines.add(
                String.format(" - 回数: %s", usageContent));
    }
}
