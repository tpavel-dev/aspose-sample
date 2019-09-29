package company.api.impl;

import company.model.OrgStruct;
import company.service.OrgStructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org-struct")
public class OrgStructRestControllerImpl {

    @Autowired
    private OrgStructService service;

    @GetMapping("/")
    public OrgStruct GetRoot() {
        return service.getOrgStruct();
    }
}
