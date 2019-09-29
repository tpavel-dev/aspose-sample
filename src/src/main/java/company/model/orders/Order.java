package company.model.orders;

import java.time.LocalDate;

public interface Order {
     LocalDate getDate();
     OrderType getType();

}
