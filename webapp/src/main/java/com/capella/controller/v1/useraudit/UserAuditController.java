package com.capella.controller.v1.useraudit;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.useraudit.UserAuditFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userAuditControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.USERAUDIT)
@RequiredArgsConstructor
@Slf4j
public class UserAuditController {

    protected final UserAuditFacade userAuditFacade;

    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of UserAuditController");
        var userAuditDatas = userAuditFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(userAuditDatas);
        return response;
    }
}
