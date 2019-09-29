package company.api.impl;

import company.api.StaffsRestController;
import company.model.Staff;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Slf4j
public class StaffsRestControllerImpl implements StaffsRestController {

    @PostConstruct
    public void  Init() {
        log.info("StaffsRestControllerImpl");
    }

    @Override
    public List<Staff> getAll() {
        return null;
    }
}
