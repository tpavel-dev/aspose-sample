package company.service;

import company.model.Persona;
import company.model.Staff;
import company.repository.PersonaRepository;
import company.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StaffService {

    @Autowired
    private StaffRepository repository;

    public void register(Staff staff) {
        log.info("Reg {}", staff);
        repository.add(staff);
    }

    public void unregister(Staff staff) {
        log.info("UnReg {}", staff);
        repository.remove(staff);
    }

    public Staff findBySocId(String socialCode) {
        Optional<Staff> bySocId = repository.findBySocId(socialCode);

        return bySocId.get();
    }

    public List<Staff> getAll() {
        return repository.getAll();
    }

    public Staff finByName(String name) {
        throw new UnsupportedOperationException("No implemented");
    }
}
