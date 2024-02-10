package advanced.dependency.injection.di.injector;

import advanced.dependency.injection.di.consumer.IConsumer;
import advanced.dependency.injection.di.consumer.MyDiApplication;
import advanced.dependency.injection.di.service.EmailServiceImpl;

public class EmailServiceInjector implements IMessageServiceInjector {

    @Override
    public IConsumer getConsumer() {
        return new MyDiApplication(new EmailServiceImpl());
    }
}