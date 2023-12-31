package com.capella.facade.costlevel.impl;

import com.capella.domain.data.costlevel.CostLevelData;
import com.capella.domain.model.costlevel.CostLevelModel;
import com.capella.facade.costlevel.CostLevelFacade;
import com.capella.service.costlevel.CostLevelService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class CostLevelFacadeImpl implements CostLevelFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final CostLevelService costLevelService;

    @Override
    public void save(CostLevelData costLevelData) {
        CostLevelModel costLevelModel;
        if(costLevelData.isNew()){
            costLevelModel = modelMapper.map(costLevelData, CostLevelModel.class);
            costLevelModel.setCode(UUID.randomUUID().toString());
        }else{
            costLevelModel = costLevelService.getCostLevelModel(costLevelData.getCode());
            modelMapper.map(costLevelData, costLevelModel);
        }
        modelService.save(costLevelModel);
    }

    @Override
    public Set<CostLevelData> getAll() {
        var costLevelModels = costLevelService.getCostLevelModels();
        return Set.of(modelMapper.map(costLevelModels, CostLevelData[].class));
    }

    @Override
    public CostLevelData get(String code) {
        var costLevelModel = costLevelService.getCostLevelModel(code);
        return modelMapper.map(costLevelModel,CostLevelData.class);
    }

    @Override
    public void delete(String code) {
        var costLevelModel = costLevelService.getCostLevelModel(code);
        modelService.remove(costLevelModel);
    }
}
