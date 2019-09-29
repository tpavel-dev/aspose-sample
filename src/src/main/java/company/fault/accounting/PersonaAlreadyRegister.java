package company.fault.accounting;

public class PersonaAlreadyRegister extends AccountingException {
    public PersonaAlreadyRegister() {
    }

    public PersonaAlreadyRegister(String message) {
        super(message);
    }

    public PersonaAlreadyRegister(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonaAlreadyRegister(Throwable cause) {
        super(cause);
    }

    public PersonaAlreadyRegister(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
