package com.capella.controller.v1.cronjob;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.cronjob.CronJobData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.cronjob.CronJobFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("cronJobControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.CRONJOB)
@RequiredArgsConstructor
@Slf4j
public class CronJobController {
    protected final CronJobFacade cronJobFacade;

    @PostMapping
    public ServiceResponseData save(@Validated @RequestBody CronJobData cronJobData){
        log.info("Inside save of CronJobController",cronJobData);
        cronJobFacade.save(cronJobData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
    @GetMapping(ControllerMappings.CODE)
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of CronJobController",code);
        var cronJobData = cronJobFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(cronJobData);
        return response;
    }
    @GetMapping
    public ServiceResponseData getAll(){
        log.info("Inside getAll of CronJobController");
        var cronJobDatas = cronJobFacade.getAll();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(cronJobDatas);
        return response;
    }
    @DeleteMapping(ControllerMappings.CODE)
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of CronJobController",code);
        cronJobFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }
}
