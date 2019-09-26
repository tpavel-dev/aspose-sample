package company.ordering;

import company.fault.accounting.AlreadyStaff;
import company.fault.accounting.StaffNotExistException;

public interface  OrderProcessor<O> {
    void process(O order) throws AlreadyStaff, StaffNotExistException;
}
