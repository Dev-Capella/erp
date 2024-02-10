package com.capella.facade.domainmodel.impl;

import com.capella.base.constant.PackageConstant;
import com.capella.base.util.ErpClassUtils;
import com.capella.domain.data.domainmodel.DomainModelData;
import com.capella.facade.domainmodel.DomainModelFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
@Slf4j
public class DomainModelFacadeImpl implements DomainModelFacade {
    @Override
    public List<DomainModelData> getAllDomainModels() {
        var itemClasses = ErpClassUtils.getClassesForPackage(PackageConstant.DOMAIN_PACKAGE);

        return itemClasses.stream()
                .filter(c -> StringUtils.startsWith(c.getName(),PackageConstant.DOMAIN_PACKAGE) && StringUtils.endsWith(c.getName(), PackageConstant.MODEL_PREFIX))
                .map(p -> {
                    var domainModelData = new DomainModelData();
                    domainModelData.setCode(p.getSimpleName());
                    domainModelData.setName(p.getSimpleName());
                    return domainModelData;
                }).sorted(Comparator.comparing(DomainModelData::getName)).collect(Collectors.toList());
    }
}
