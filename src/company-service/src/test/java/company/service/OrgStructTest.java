package company.service;

import company.model.HiringOrder;
import company.model.Order;
import company.model.StaffPosition;
import company.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        PersonService.class,
        PersonaRepository.class,
        StaffService.class,
        StaffPosition.class,
        AccountingService.class
})
@Slf4j
public class OrgStructTest {

    @Autowired
    private AccountingService accountingService;

    @Autowired
    private PersonService personService;

    @Autowired
    private StaffService staffService;


    void buildOrgStruct() {
        HiringOrder hiring = HiringOrder.builder().persona(personService.finBySocialCode("11"))
                .staff(staffService.findBySocId("12"))
                .position(StaffPosition.Employee).salary(100)
                .build();
        accountingService.processOrder(hiring);
    }

    @Test
    void parsePuml() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("org-struct.puml"))) {
            lines.forEachOrdered(log::info);

        }
    }
}
