package advanced.dependency.injection.di.consumer;

public interface IConsumer {
    void processMessages(String message, String receiver);
}