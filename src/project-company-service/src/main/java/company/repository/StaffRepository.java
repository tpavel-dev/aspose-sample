package company.repository;

import company.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepository {
    List<Staff> staffList = new ArrayList<>();

    public void add(Staff staff) {
        staffList.add(staff);
    }

    public void remove(Staff staff) {
        staffList.remove(staff);
    }

    public Optional<Staff> findBySocId(String socid) {
        Optional<Staff> staff = staffList.stream()
                .filter(s -> s.getPersona().getSocialCode().equals(socid))
                .findFirst();

        return staff;
    }

    public List<Staff> getAll() {
        return staffList;
    }

}
