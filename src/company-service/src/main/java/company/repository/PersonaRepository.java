package company.repository;

import company.model.Persona;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaRepository {
    List<Persona> personsList = new ArrayList<>();

    public void add(Persona persona) {
        personsList.add(persona);
    }

    public void remove(Persona persona) {
        personsList.remove(persona);
    }

    public List<Persona> getAll() {
        return personsList;
    }
}
