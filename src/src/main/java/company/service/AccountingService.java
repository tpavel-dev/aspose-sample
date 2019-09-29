package company.service;

import company.fault.accounting.AccountingException;
import company.fault.accounting.CaseException;
import company.model.PaymentStatement;
import company.model.PaymentStatementReport;
import company.model.orders.Order;
import company.model.OrgStruct;
import company.model.Staff;
import company.ordering.OrderProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountingService {

    @Autowired
    private OrgStruct orgStruct;

    @Autowired
    private StaffService staffService;

    @Autowired
    private Set<OrderProcessor> orderProcessorsList;
    private Map<? extends Class<? extends Order>, OrderProcessor> orderProcessorMap;


    @PostConstruct
    public void init() {
        orderProcessorMap = orderProcessorsList.stream()
                .collect(Collectors.toMap(OrderProcessor::availableOrderClass, o -> o));
    }

    public void processOrder(Order order) throws CaseException {
        log.info("Process order {}", order);
        OrderProcessor orderProcessor = orderProcessorMap.get(order.getClass());
        if (orderProcessor == null) {
            throw new IllegalStateException("Not found order processor for {}"
                    + order.getClass().getSimpleName());
        }

        orderProcessor.process(order);
    }

    public PaymentStatementReport paymentStatementReport(LocalDate affectdata) {
        return new PaymentStatementReport(
                staffService.getAll().stream()
                        .filter(s -> s.getPersonalSalaryModel() != null)
                        .map(s -> {
                            var salary = s.getPersonalSalaryModel().calculate(s, affectdata);
                            return PaymentStatement.builder()
                                    .staff(s)
                                    .salary(salary)
                                    .build();
                        }).collect(Collectors.toList())
        );
    }
}
