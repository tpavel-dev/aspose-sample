package company.ordering;

import company.fault.accounting.AlreadyStaff;
import company.fault.accounting.StaffNotExistException;
import company.model.OrgStructRelation;
import company.model.orders.HiringOrder;
import company.model.Staff;
import company.service.OrgStructService;
import company.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static company.model.OrgStructRelation.*;

@Component
public class HiringOrderProcessor implements OrderProcessor<HiringOrder> {

    @Autowired
    private StaffService staffService;

    @Autowired
    private OrgStructService orgStructService;

    @Override
    public void process(HiringOrder order) throws AlreadyStaff, StaffNotExistException {
        try {
            Staff bySocId = staffService.findBySocId(order.getPersona().getSocialCode());
            if (bySocId != null) {
                throw new AlreadyStaff();
            }
        } catch (StaffNotExistException ignore){}

        Staff newStaff = Staff.builder()
                .persona(order.getPersona())
                .baseSalary(order.getSalary())
                .position(order.getPosition())
                .build();

        var master = order.getStaff();

        newStaff.getOrders().add(order);

        staffService.register(newStaff);

        orgStructService.registrationReletions(master, newStaff, CHIEF);
    }

    @Override
    public Class<? extends HiringOrder> availableOrderClass() {
        return HiringOrder.class;
    }

}
