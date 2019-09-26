package company.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Persona {
    private String name;
    private Date birthday;

    @EqualsAndHashCode.Include
    private String socialCode;
}
