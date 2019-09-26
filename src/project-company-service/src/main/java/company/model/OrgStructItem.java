package company.model;

import lombok.Data;

import java.util.List;

@Data
public class OrgStructItem {
    private OrgStructRelation relation;
    private Staff master;
    private List<Staff> slave;
}
