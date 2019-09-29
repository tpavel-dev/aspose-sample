package company.repository;

import company.model.Persona;
import company.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepository {
    List<Staff> staffList = new ArrayList<>();

    @Autowired
    private Staff root;

    @PostConstruct
    public void init() {
        staffList.add(root);
    }


    public void add(Staff staff) {
        staffList.add(staff);
    }

    public void remove(Staff staff) {
        staffList.remove(staff);
    }

    public Optional<Staff> findBySocId(String socid) {
        Optional<Staff> staff = staffList.stream()
                .filter(s -> s.getPersona().getSocialCode().equalsIgnoreCase(socid))
                .findFirst();

        return staff;
    }

    public List<Staff> getAll() {
        return staffList;
    }

}
