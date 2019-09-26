package company.fault.accounting;

public class AccountingException extends CaseException {
    public AccountingException() {
    }

    public AccountingException(String message) {
        super(message);
    }

    public AccountingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountingException(Throwable cause) {
        super(cause);
    }

    public AccountingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
