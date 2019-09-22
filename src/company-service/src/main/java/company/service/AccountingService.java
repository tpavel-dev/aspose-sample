package company.service;

import company.accounting.AccountingException;
import company.model.Order;
import company.model.OrgStruct;
import company.model.Staff;

import java.util.Date;

public class AccountingService {
    private OrgStruct orgStruct;

    public void  ProcessOrder(Order order) {
        throw new UnsupportedOperationException("No implemented");
    }

    public Integer calculateSalary(Staff staff, Date from, Date to) throws AccountingException {
        return staff.getPersonalSalaryModel().calculate(this.orgStruct, staff, from, to);
//        throw new UnsupportedOperationException("No implemented");
    }
}
