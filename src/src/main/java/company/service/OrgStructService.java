package company.service;

import company.model.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OrgStructService {

    @Autowired
    @Getter
    private OrgStruct orgStruct;

    public void registrationReletions(
            Staff master, Staff slave, OrgStructRelation relation
    ) {
        // todo check relation
        OrgStructItem item = OrgStructItem.builder()
                .master(master)
                .slave(slave)
                .relation(relation)
                .build();

        orgStruct.getRelationsList().add(item);
        orgStruct.getRelationsMap().put(master, item);
    }

    public List<Staff> getSubordinatesFirstlevel(Staff staff) {
        return Collections.emptyList();
    }

    public List<Staff> getSubordinatesAllLevels(Staff staff) {
        return Collections.emptyList();
    }
}
