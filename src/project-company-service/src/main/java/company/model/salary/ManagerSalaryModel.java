package company.model.salary;

import company.model.CurrentState;
import company.model.OrgStruct;
import company.model.Staff;
import company.service.OrgStructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.DoubleSummaryStatistics;

@Component
public class ManagerSalaryModel implements SalaryModel {

    @Autowired
    private OrgStructService orgStructService;

    @Override
    public double calculate(
            Staff staff,
            LocalDate effectDate
    ) {
        if (effectDate.isBefore(staff.getHiringDate())) {
            throw new IllegalStateException("effect date must be after hiring date");
        }
        var period = Period.between(staff.getHiringDate(), effectDate);

        var salary = staff.getBaseSalary() + (staff.getBaseSalary() * period.getYears() * 0.05);
        if (salary > staff.getBaseSalary() + (staff.getBaseSalary() * 0.4)) {
            salary = staff.getBaseSalary() + (staff.getBaseSalary() * 0.4);
        }

        var subordinates = orgStructService.getSubordinatesFirstlevel(staff);
        if (subordinates.size() > 0) {
            salary = salary + subordinates.stream()
                    .mapToDouble(s -> s.getPersonalSalaryModel().calculate(s, effectDate))
                    .sum() * 0.5;
        }

        return salary;

    }
}
