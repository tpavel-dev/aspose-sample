package company.model.salary;

import company.model.CurrentState;
import company.model.OrgStruct;
import company.model.Staff;

import java.time.LocalDate;

public interface SalaryModel {
    double calculate(
            Staff staff,
            LocalDate effectDate
    );
}
