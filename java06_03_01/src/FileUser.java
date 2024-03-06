import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class FileUser {

    public static void main(String[] args) {
        try {
            findFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void findFile() throws IOException{

        File newFile = new File("test.txt");
        FileInputStream stream = new FileInputStream(newFile);
        stream.close();
    }
}