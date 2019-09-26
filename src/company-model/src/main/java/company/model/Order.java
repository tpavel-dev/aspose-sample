package company.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

//@Builder
@Data
public class Order {
    private Date date;
    private OrderType type;
}
