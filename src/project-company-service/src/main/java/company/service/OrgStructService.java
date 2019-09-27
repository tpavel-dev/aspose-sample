package company.service;

import company.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgStructService {

    @Autowired
    private OrgStruct orgStruct;

    public void registrationReletions(Staff master, Staff slave, OrgStructRelation relation) {
        // todo check relation
        OrgStructItem item = OrgStructItem.builder()
                .master(master)
                .slave(slave)
                .relation(relation)
                .build();

        orgStruct.getRelationsList().add(item);
        orgStruct.getRelationsMap().put(master, item);
    }
}
