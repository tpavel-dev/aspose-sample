package company.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Component
public class OrgStruct {
    OrgStructRelation roots;
    List<OrgStructItem> relationsList = new ArrayList<>();
    Map<Staff, OrgStructItem> relationsMap  = new HashMap<>();
}
