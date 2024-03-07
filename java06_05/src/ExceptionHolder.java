public class ExceptionHolder {
    private String message;
    private StackTraceElement[] stackTraceElements;

    public ExceptionHolder(Throwable e) {
        this.message = e.getMessage();
        this.stackTraceElements = e.getStackTrace();
    }

    public void showExceptionMessage() {
        System.out.format("発生した例外 => %s %n", this.message);
    }

    public void showStackTrace() {
        System.out.println("スタックトレース:");
        
        for (int i = 0; i < this.stackTraceElements.length; i++) {
            System.out.format(
                "  at %s %n", this.stackTraceElements[i]);
        }
    }
}