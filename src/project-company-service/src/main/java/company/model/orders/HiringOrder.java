package company.model.orders;

import company.model.Persona;
import company.model.Staff;
import company.model.StaffPosition;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper=false)
public class HiringOrder extends Order {
    private Persona persona;
    private StaffPosition position;
    private Staff staff;
    private Integer salary;
}
