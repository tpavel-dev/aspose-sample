package company.ordering;

import company.fault.accounting.AlreadyStaff;

public interface  OrderProcessor<O> {
    void process(O order) throws AlreadyStaff;
}
