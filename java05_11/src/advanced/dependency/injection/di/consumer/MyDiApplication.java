package advanced.dependency.injection.di.consumer;

import advanced.dependency.injection.di.service.IMessageService;

public class MyDiApplication implements IConsumer {

    private IMessageService service;
    
    public MyDiApplication(IMessageService service) {
        this.service = service;
    }
    
    @Override
    public void processMessages(String message, String receiver) {
        // message のバリデーション、操作ロジックなどを行う
        this.service.sendMessage(message, receiver);
    }
}
