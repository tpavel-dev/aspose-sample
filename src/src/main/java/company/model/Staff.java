package company.model;

import company.model.orders.Order;
import company.model.salary.SalaryModel;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class Staff {
    private Persona persona;
    private Integer baseSalary;
    private LocalDate hiringDate;
    @Builder.Default
    private List<Order> orders = new ArrayList<>();
    private SalaryModel personalSalaryModel;
    private StaffPosition position;
}
