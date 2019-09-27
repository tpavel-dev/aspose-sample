package company.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
public class OrgStruct {
    OrgStructRelation roots;
    List<OrgStructItem> relationsList;
    Map<Staff, OrgStructItem> relationsMap;
}
