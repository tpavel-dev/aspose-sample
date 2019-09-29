package company.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class PaymentStatementReport {
    private List<PaymentStatement> items = new ArrayList<>();
}
