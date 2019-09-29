package company.api.impl;

import company.model.PaymentStatementReport;
import company.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("acc")
public class AccountingRestControllerImpl {

    @Autowired
    private AccountingService service;

    @GetMapping("payment-statement-report/{reportDate}")
    public PaymentStatementReport paymentStatementReport(
            @PathVariable String reportDate
    ) {
        return service.paymentStatementReport(LocalDate.parse(reportDate));
    }
}
