package company.model.salary;

import company.model.OrgStruct;
import company.model.Staff;

import java.util.Date;

public interface SalaryModel {
    Integer calculate(OrgStruct orgStruct, Staff staff, Date from, Date to);
}
