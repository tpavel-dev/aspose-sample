package company.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PaymentStatement {
    private Staff staff;
    private Double salary;
}
