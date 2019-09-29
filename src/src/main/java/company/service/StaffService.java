package company.service;

import company.fault.accounting.AlreadyStaff;
import company.fault.accounting.StaffNotExistException;
import company.model.Staff;
import company.repository.StaffRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StaffService {

    @Autowired
    private StaffRepository repository;


    public void register(Staff staff) throws AlreadyStaff {
        log.info("Reg {}", staff);
        Optional<Staff> bySocId = repository.findBySocId(staff.getPersona().getSocialCode());
        if(bySocId.isPresent()) {
            throw new AlreadyStaff();
        }
        repository.add(staff);
    }

    public void unregister(Staff staff) {
        log.info("UnReg {}", staff);
        repository.remove(staff);
    }

    public Staff findBySocId(String socialCode) throws StaffNotExistException {
        Optional<Staff> staff = repository.findBySocId(socialCode);
        if( staff.isEmpty()) {
            throw  new StaffNotExistException();
        }
        return staff.get();
    }

    public List<Staff> getAll() {
        return repository.getAll();
    }

    public Staff finByName(String name) {
        throw new UnsupportedOperationException("No implemented");
    }
}
