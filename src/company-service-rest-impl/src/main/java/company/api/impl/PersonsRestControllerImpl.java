package company.api.impl;

import company.api.PersonsRestController;
import company.model.Persona;
import company.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonsRestControllerImpl implements PersonsRestController {
    @Autowired
    private PersonService personService;

    @Override
    public List<Persona> getAll() {
        return personService.getAll();
    }
}
