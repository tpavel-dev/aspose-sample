package company.model.orders;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

//@Builder
@Data
public class Order {
    private LocalDate date;
    private OrderType type;
}
