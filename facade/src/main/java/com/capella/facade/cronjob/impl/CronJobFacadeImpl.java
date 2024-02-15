package com.capella.facade.cronjob.impl;

import com.capella.domain.data.cronjob.CronJobData;
import com.capella.domain.model.cronjob.CronJobModel;
import com.capella.facade.cronjob.CronJobFacade;
import com.capella.service.cronjob.CronJobService;
import com.capella.service.model.ModelService;
import com.capella.service.util.ServiceUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CronJobFacadeImpl implements CronJobFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CronJobService cronJobService;
    @Override
    public void save(CronJobData cronJobData) {
        CronJobModel cronJobModel;
        if(cronJobData.isNew()){
            cronJobModel = modelMapper.map(cronJobData, CronJobModel.class);
            ServiceUtils.generateCodeIfMissing(cronJobModel);
        }else{
            cronJobModel = cronJobService.getCronJobModel(cronJobData.getCode());
            modelMapper.map(cronJobData, cronJobModel);
        }
        modelService.save(cronJobModel);
    }

    @Override
    public Set<CronJobData> getAll() {
        var cronJobModels = cronJobService.getCronJobModels();
        return Set.of(modelMapper.map(cronJobModels, CronJobData[].class));
    }

    @Override
    public CronJobData get(String code) {
        var cronJobModel = cronJobService.getCronJobModel(code);
        return modelMapper.map(cronJobModel,CronJobData.class);
    }

    @Override
    public void delete(String code) {
        var cronJobModel = cronJobService.getCronJobModel(code);
        modelService.remove(cronJobModel);
    }
}
