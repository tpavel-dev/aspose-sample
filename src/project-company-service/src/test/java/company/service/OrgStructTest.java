package company.service;

import company.fault.accounting.CaseException;
import company.fault.accounting.PersonaIsNotRegisterException;
import company.fault.accounting.StaffNotExistException;
import company.model.OrgStruct;
import company.model.orders.HiringOrder;
import company.model.Persona;
import company.model.StaffPosition;
import company.ordering.DismissalOrderProcessor;
import company.ordering.HiringOrderProcessor;
import company.repository.PersonaRepository;
import company.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        PersonService.class,
        PersonaRepository.class,
        StaffService.class,
        StaffPosition.class,
        StaffRepository.class,
        AccountingService.class,
        HiringOrderProcessor.class,
        DismissalOrderProcessor.class,
        OrgStruct.class,
})
@Slf4j
public class OrgStructTest {

    @Autowired
    private AccountingService accountingService;

    @Autowired
    private PersonService personService;

    @Autowired
    private StaffService staffService;

    @Autowired
//    private AccountingService accountingService;


//    void buildOrgStruct() throws CaseException {
//        HiringOrder hiring = HiringOrder.builder()
//                .persona(personService.finBySocialCode("11"))
//                .staff(staffService.findBySocId("12"))
//                .position(StaffPosition.Employee).salary(100)
//                .build();
//        accountingService.processOrder(hiring);
//    }

    @Test
    void parsePuml() throws IOException, URISyntaxException {
        Stream<String> lines = loadPuml();
        lines.forEachOrdered(this::parseLine);
    }

    private void parseLine(String s) {
        try {
            log.info("parse: {}", s);
            String[] tokens = s.split("\\s");

            // skip empty line
            if (tokens.length < 1) return;

            var startToken = tokens[0];
            var controllChar = startToken.charAt(0);

            // skip plantuml start end
            if (controllChar == '@') return;

            // registration persona
            if (controllChar == ':') {
                var personaEntity = startToken.substring(1, startToken.length() - 1);
                this.personService.register(
                        Persona.builder()
                                .name(personaEntity)
                                .socialCode(personaEntity)
                                .build()
                );
                return;
            }

            // parse relation line
            if (tokens.length < 4) return;
            var headId = startToken;
            var personaId = tokens[2];
            var addInfo = tokens[3];
            var position = addInfo.substring(2, addInfo.length() - 2);

            var persona = personService.finBySocialCode(personaId);
            var head = staffService.findBySocId(headId);

            var hiringOrder = HiringOrder
                    .builder()
                    .persona(persona)
                    .staff(head)
                    .position(StaffPosition.valueOf(position))
                    .build();

            accountingService.processOrder(hiringOrder);

        } catch (Exception err) {
            log.error(err.getMessage(),err);
        }
    }

    private Stream<String> loadPuml() throws URISyntaxException, IOException {
        var classLoader = ClassLoader.getSystemClassLoader();
        var url = classLoader.getResource("org-struct.puml").toURI();
        var path = Path.of(url);
        return Files.lines(path);
    }
}
