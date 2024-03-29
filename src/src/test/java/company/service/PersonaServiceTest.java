package company.service;

import company.model.Persona;
import company.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PersonService.class, PersonaRepository.class})
@Slf4j
public class PersonaServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void regPersons() throws Exception {
        personService.register(Persona.builder().socialCode("11").name("Worker11").build());
        personService.register(Persona.builder().socialCode("22").name("Worker12").build());
        List<Persona> all = personService.getAll();
        assertEquals(2, all.size());
    }




}
