package company.api;

import company.model.Staff;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/staffs")
public interface StaffsRestController {

    @GetMapping("/")
    List<Staff> getAll();

}
