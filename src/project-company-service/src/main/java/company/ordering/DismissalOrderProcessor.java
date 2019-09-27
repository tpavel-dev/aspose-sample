package company.ordering;

import company.fault.accounting.CaseException;
import company.model.orders.DismissalOrder;
import org.springframework.stereotype.Component;

@Component
public class DismissalOrderProcessor implements OrderProcessor<DismissalOrder> {

    @Override
    public void process(DismissalOrder order) throws CaseException {

    }

    @Override
    public Class<? extends DismissalOrder> availableOrderClass() {
        return DismissalOrder.class;
    }
}
