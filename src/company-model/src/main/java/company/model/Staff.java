package company.model;

import company.model.salary.SalaryModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Staff {
    private Persona persona;
    private List<Order> orders;
    private Integer baseSalary;
    private SalaryModel personalSalaryModel;
}
