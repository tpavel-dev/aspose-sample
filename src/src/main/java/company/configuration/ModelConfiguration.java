package company.configuration;

import company.model.Persona;
import company.model.Staff;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

    @Bean("root")
    public Staff rootStaff() {
        return Staff.builder()
                .persona(
                        Persona.builder()
                                .name("root")
                                .socialCode("root")
                                .build()
                )
                .build();

    }
}
