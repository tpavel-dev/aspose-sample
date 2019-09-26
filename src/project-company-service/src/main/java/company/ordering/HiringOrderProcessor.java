package company.ordering;

import company.fault.accounting.AlreadyStaff;
import company.fault.accounting.StaffNotExistException;
import company.model.HiringOrder;
import company.model.Staff;
import company.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HiringOrderProcessor implements OrderProcessor<HiringOrder> {

    @Autowired
    private StaffService staffService;

    @Override
    public void process(HiringOrder order) throws AlreadyStaff, StaffNotExistException {
        Staff bySocId = staffService.findBySocId(order.getPersona().getSocialCode());
        if (bySocId != null) {
            throw new AlreadyStaff();
        }
        order.getPersona();
    }
}
