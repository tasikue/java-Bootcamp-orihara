package exception;

public class AppException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public AppException(ErrorCode code, Exception e){
        super(String.format(
            "%s: %s",
            code.getType(),
            code.getMessage()),
            e);
    }
}
