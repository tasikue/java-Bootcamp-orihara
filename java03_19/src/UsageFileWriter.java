import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UsageFileWriter {

    static final Path DIR_PATH = Paths.get("C:\\tmp");
    static final Path FILE_PATH = Paths.get("C:\\tmp\\test.txt");

    public static void main(String[] args) {

        String name = "山本一郎";
        int usageContent = 5;
        
        // ディレクトリの存在確認
        try {
            FileManager.createDirIfNotExists(DIR_PATH);;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // ファイルの存在確認
        try {
            FileManager.createFileIfNotExists(DIR_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //　利用回数内容の作成
        List<String> lines = new ArrayList<>();
        Usage.createUsageContent(lines, name, usageContent);

        // ファイルへの書き込み
        try {
            FileManager.writeToFile(DIR_PATH, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ファイル内容の読み込み
        List<String> readLines = new ArrayList<>();
        try {
            readLines = FileManager.readFileAllContents(FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ファイル内容の表示
        Loggers.showLog("ファイル内容を表示します...");
        Loggers.showContents(readLines);
    }
}