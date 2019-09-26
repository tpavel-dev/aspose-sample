package company.repository;

import company.model.Persona;
import company.model.Staff;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaRepository {
    List<Persona> personsList = new ArrayList<>();

    public void add(Persona persona) {
        personsList.add(persona);
    }

    public void remove(Persona persona) {
        personsList.remove(persona);
    }

    public Optional<Persona> findBySocId(String socid) {
        Optional<Persona> person = personsList.stream()
                .filter(p -> p.getSocialCode().equals(socid))
                .findFirst();

        return person;
    }

    public List<Persona> getAll() {
        return personsList;
    }

}
