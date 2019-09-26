package company.service;

import company.model.Persona;
import company.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonaRepository repository;

    public void register(Persona persona) {
        log.info("Reg {}", persona);
        repository.add(persona);
    }

    public void unregister(Persona persona) {
        log.info("UnReg {}", persona);
        repository.remove(persona);
    }

    public List<Persona> getAll() {
        return repository.getAll();
    }

    public Persona finByName(String name) {
        throw new UnsupportedOperationException("No implemented");
    }

    public Persona finBySocialCode(String spcialCode) {
        throw new UnsupportedOperationException("No implemented");
    }
}
