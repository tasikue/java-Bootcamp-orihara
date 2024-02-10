package advanced.dependency.injection.di.service;

public class EmailServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String message, String receiver) {
        
        // メール送信のビジネスロジック
        System.out.format(
                "[Email] 送信先: %s, メッセージ: %s %n",
                receiver, message
            );
    }
 }
