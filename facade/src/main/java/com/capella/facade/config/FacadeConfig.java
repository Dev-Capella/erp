package com.capella.facade.config;

import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.model.itemtype.ItemTypeModel;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacadeConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull())
                .setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.addMappings(new PropertyMap<ItemTypeData, ItemTypeModel>() {
            @Override
            protected void configure() {
                skip(destination.getPrimaryUOM());
                skip(destination.getSecondaryUOM());
                skip(destination.getPackagingUOM());
            }
        });

        return modelMapper;

    }
}
