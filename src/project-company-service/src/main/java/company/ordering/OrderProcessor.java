package company.ordering;

import company.fault.accounting.CaseException;
import company.model.orders.Order;

public interface  OrderProcessor<ORDER extends Order> {
    void process(ORDER order) throws CaseException;

    Class<? extends ORDER> availableOrderClass();
}
