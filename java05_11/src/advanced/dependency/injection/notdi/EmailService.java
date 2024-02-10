package advanced.dependency.injection.notdi;

public class EmailService {
    
    public void sendEmail(String message, String receiver){
        // メール送信のビジネスロジック
        System.out.format(
                "[Email] 送信先: %s, メッセージ: %s %n",
                receiver, message
            );
    }
}