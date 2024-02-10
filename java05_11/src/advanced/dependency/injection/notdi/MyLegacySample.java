package advanced.dependency.injection.notdi;

public class MyLegacySample {

    public static void main(String[] args) {

        MyApplication app = new MyApplication();
        
        app.processMessages(
                "こんにちは、山本一郎さん！",
                "i_yamamoto@abc.com"
            );
    }
}