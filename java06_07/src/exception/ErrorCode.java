package exception;

public enum ErrorCode {
    UNEXPECTED(
        "UnecpectedError",
        "想定外の値が設定されています．"),

    INCORRECT_HANDLING(
        "IncorrectHandlingError",
        "間違った処理が行われました．"),;
        
    private String type;
    private String message;

    private ErrorCode(String type, String message){
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return this.type;
    }

    public String getMessage(){
        return this.message;
    }
}
