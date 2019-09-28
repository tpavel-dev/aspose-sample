package company.service;

import company.fault.accounting.AccountingException;
import company.fault.accounting.CaseException;
import company.model.orders.Order;
import company.model.OrgStruct;
import company.model.Staff;
import company.ordering.OrderProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountingService {

    @Autowired
    private OrgStruct orgStruct;

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
        if(orderProcessor == null) {
            throw new IllegalStateException("Not found order processor for {}"
                    + order.getClass().getSimpleName());
        }

        orderProcessor.process(order);
    }

    public Integer calculateSalary(Staff staff, Date from, Date to) throws AccountingException {
//        staff.setBaseSalary(100);
        return null;
//        return staff.getPersonalSalaryModel().calculate(this.orgStruct, staff, from, to);
//        return staff.getPersonalSalaryModel().calculate(this.orgStruct, staff, from, to);
//        throw new UnsupportedOperationException("No implemented");
    }
}
