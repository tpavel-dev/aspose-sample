package company.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrgStructItem {
    private OrgStructRelation relation;
    private Staff master;
    private Staff slave;
}
