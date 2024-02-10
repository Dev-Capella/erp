package com.capella.controller.v1.usergenericgroupdetail;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.data.usergenericgroupdetail.UserGenericGroupDetailData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.compositiondetail.CompositionDetailFacade;
import com.capella.facade.usergenericgroupdetail.UserGenericGroupDetailFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("userGenericGroupDetailControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.USERGENERICGROUPDETAIL)
@RequiredArgsConstructor
@Slf4j
public class UserGenericGroupDetailController {

    protected final UserGenericGroupDetailFacade userGenericGroupDetailFacade;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('User_Generic_Group_Detail_Save')")
    public ServiceResponseData save(@Validated @RequestBody UserGenericGroupDetailData userGenericGroupDetailData){
        log.info("Inside save of UserGenericGroupDetailController",userGenericGroupDetailData);
        userGenericGroupDetailFacade.save(userGenericGroupDetailData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    @PreAuthorize("hasAnyAuthority('User_Generic_Group_Detail_Remove')")
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of UserGenericGroupDetailController",code);
        userGenericGroupDetailFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    @PreAuthorize("hasAnyAuthority('User_Generic_Group_Detail_Read')")
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of UserGenericGroupDetailController",code);
        var compositionDetailData = userGenericGroupDetailFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(compositionDetailData);
        return response;
    }
}
