package company.service;

import company.fault.accounting.CaseException;
import company.fault.accounting.PersonaIsNotRegisterException;
import company.fault.accounting.StaffNotExistException;
import company.model.OrgStruct;
import company.model.orders.HiringOrder;
import company.model.Persona;
import company.model.StaffPosition;
import company.ordering.DismissalOrderProcessor;
import company.ordering.HiringOrderProcessor;
import company.repository.PersonaRepository;
import company.repository.StaffRepository;
import company.sample.SampleDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        PersonService.class,
        PersonaRepository.class,
        StaffService.class,
        StaffPosition.class,
        StaffRepository.class,
        AccountingService.class,
        HiringOrderProcessor.class,
        DismissalOrderProcessor.class,
        OrgStruct.class,
        OrgStructService.class,
        SampleDataLoader.class,
})
@Slf4j
public class OrgStructTest {

    @Autowired
    private SampleDataLoader loader;

    @Test
    void parsePuml() throws Exception {
        loader.LoadSampleData();
    }
}
