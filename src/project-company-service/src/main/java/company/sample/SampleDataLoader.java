package company.sample;

import company.model.Persona;
import company.model.StaffPosition;
import company.model.orders.HiringOrder;
import company.service.AccountingService;
import company.service.PersonService;
import company.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
@Slf4j
public class SampleDataLoader {

    @Autowired
    private AccountingService accountingService;

    @Autowired
    private PersonService personService;

    @Autowired
    private StaffService staffService;

    public void LoadSampleData() throws Exception {
        parsePuml();
    }

    private void parsePuml() throws IOException, URISyntaxException {
        Stream<String> lines = loadPuml();
        lines.forEachOrdered(this::parseLine);
    }

    private Stream<String> loadPuml() throws URISyntaxException, IOException {
        var classLoader = ClassLoader.getSystemClassLoader();
        var url = classLoader.getResource("org-struct.puml").toURI();
        var path = Path.of(url);
        return Files.lines(path);
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
            log.error(err.getMessage(), err);
        }
    }
}
