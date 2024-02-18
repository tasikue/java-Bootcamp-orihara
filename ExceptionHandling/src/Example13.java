import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class Example13 {
    public static void main(String[] args) {
        FileReader fr;
        try {
            String filePath = Paths.get("").toAbsolutePath() + File.separator + "src" + File.separator + "something.txt";
            fr = new FileReader(filePath);

            BufferedReader br = new BufferedReader(fr);

            String data;
            while((data = br.readLine()) != null){
                System.out.println(data);
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        // 検査例外と非検査例外が存在している
    }
}
