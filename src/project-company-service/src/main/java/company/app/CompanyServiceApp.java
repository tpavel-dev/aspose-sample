package company.app;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//@PropertySource("classpath:application.properties")
@SpringBootApplication(
        scanBasePackages = {"company"}
)
@EnableAdminServer
public class CompanyServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApp.class, args);
    }

}