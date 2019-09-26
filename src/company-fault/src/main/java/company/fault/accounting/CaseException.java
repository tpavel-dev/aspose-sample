package company.fault.accounting;

/**
 * Common exception for all business cases
 */
public abstract class CaseException extends Exception {
    public CaseException() {
    }

    public CaseException(String message) {
        super(message);
    }

    public CaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaseException(Throwable cause) {
        super(cause);
    }

    public CaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
