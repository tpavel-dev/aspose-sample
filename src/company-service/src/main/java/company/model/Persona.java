package company.model;

import lombok.Data;

import java.util.Date;

@Data
public class Persona {
    private String name;
    private Date birthday;
    private String socialCode;
}
