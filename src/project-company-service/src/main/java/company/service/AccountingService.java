package company.service;

import company.fault.accounting.AccountingException;
import company.model.Order;
import company.model.OrgStruct;
import company.model.Staff;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountingService {
    private OrgStruct orgStruct;

    public void processOrder(Order order) {
        throw new UnsupportedOperationException("No implemented");
    }

    public Integer calculateSalary(Staff staff, Date from, Date to) throws AccountingException {
//        staff.setBaseSalary(100);
//        return null;
        return staff.getPersonalSalaryModel().calculate(this.orgStruct, staff, from, to);
//        return staff.getPersonalSalaryModel().calculate(this.orgStruct, staff, from, to);
//        throw new UnsupportedOperationException("No implemented");
    }
}
