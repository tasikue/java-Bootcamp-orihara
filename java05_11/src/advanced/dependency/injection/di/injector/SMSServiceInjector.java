package advanced.dependency.injection.di.injector;

import advanced.dependency.injection.di.consumer.IConsumer;
import advanced.dependency.injection.di.consumer.MyDiApplication;
import advanced.dependency.injection.di.service.SMSServiceImpl;

public class SMSServiceInjector implements IMessageServiceInjector {

    @Override
    public IConsumer getConsumer() {
        return new MyDiApplication(new SMSServiceImpl());
    }
}
