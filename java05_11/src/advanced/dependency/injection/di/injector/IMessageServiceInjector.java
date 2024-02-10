package advanced.dependency.injection.di.injector;

import advanced.dependency.injection.di.consumer.IConsumer;

public interface IMessageServiceInjector {
    public IConsumer getConsumer();
}
