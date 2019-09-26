package company.api;

import company.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/persons")
public interface PersonsRestController {

    @GetMapping("/")
    List<Persona> getAll();
}
