package mpstyle.functionalswitch;

public class InvalidFunctionalDefinitionException extends Exception {
    private Object key;

    public InvalidFunctionalDefinitionException(Object key) {
        this.key=key;
    }

    public InvalidFunctionalDefinitionException(Object key, Throwable cause) {
        super(cause);
        this.key=key;
    }

    public InvalidFunctionalDefinitionException(Object key, String message) {
        super(message);
        this.key=key;
    }

    public InvalidFunctionalDefinitionException(Object key, String message, Throwable cause) {
        super(message, cause);
        this.key=key;
    }

    public InvalidFunctionalDefinitionException(Object key, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.key=key;
    }

    public Object getKey() {
        return key;
    }
}
