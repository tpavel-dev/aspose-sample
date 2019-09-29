package company.model.orders;

import company.model.Persona;
import company.model.Staff;
import company.model.StaffPosition;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
public class DismissalOrder implements Order {
    private LocalDate date;
    private OrderType type;
    private Persona persona;
    private StaffPosition position;
    private Staff staff;
    private Integer salary;
}
