package se.inyat.exception;

public class WalletValidationException extends RuntimeException{
    private String paramName;

    public WalletValidationException(String message) {
        super(message);
    }
    public WalletValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    public String getParamName() {
        return paramName;
    }
}
