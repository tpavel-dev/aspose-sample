package company.model;

import company.model.orders.Order;
import company.model.salary.SalaryModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Staff {
    private Persona persona;
    private Integer baseSalary;
    private List<Order> orders;
    private SalaryModel personalSalaryModel;
    private StaffPosition position;
}
