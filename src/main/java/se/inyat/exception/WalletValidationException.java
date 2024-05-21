package se.inyat.exception;

public class WalletValidationException extends RuntimeException{
    private String paramName;

    public String getParamName() {
        return paramName;
    }

    public WalletValidationException(String message, String paramName) {
        super(message);
        this.paramName = paramName;
    }

    public WalletValidationException(String message, Throwable cause, String paramName) {
        super(message, cause);
        this.paramName = paramName;
    }
}