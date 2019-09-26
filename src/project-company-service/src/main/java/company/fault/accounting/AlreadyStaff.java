package company.fault.accounting;

public class AlreadyStaff extends AccountingException {
    public AlreadyStaff() {
    }

    public AlreadyStaff(String message) {
        super(message);
    }

    public AlreadyStaff(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyStaff(Throwable cause) {
        super(cause);
    }

    public AlreadyStaff(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
