package company.model.orders;

import lombok.Data;

import java.util.Date;

//@Builder
@Data
public class Order {
    private Date date;
    private OrderType type;
}
