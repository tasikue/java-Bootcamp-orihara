import java.io.FileReader;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;

public class Example12 {
    public static void main(String[] args) {
        String filePath = Paths.get("").toAbsolutePath() + File.separator + "src" + File.separator + "something.txt";
        FileReader fr = new FileReader(filePath);

        BufferedReader br = new BufferedReader(fr);

        String data;
        while((data = br.readLine()) != null){
            System.out.println(data);
        }

        br.close();
    }

    // 例外には必ず対処しなければいけないものもある。
    // これを「検査例外」や「チェック例外」という。
    // この検査例外は必ずなにか対処をしなければコンパイルエラーが発生します。
}
