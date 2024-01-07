package com.capella.facade.config;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.media.MediaData;
import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.media.MediaModel;
import com.capella.service.media.MediaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class FacadeConfig {
    protected  final MediaService mediaService;
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

        modelMapper.addMappings(new PropertyMap<CompositionDetailData, CompositionDetailModel>() {
            @Override
            protected void configure() {
                skip(destination.getCompositionComponent());
            }
        });
        modelMapper.addMappings(new PropertyMap<MediaModel, MediaData>() {
            @Override
            protected void configure() {
                Converter<MediaModel, String> mediaServePathConverter =
                        ctx -> Objects.isNull(ctx.getSource()) ? StringUtils.EMPTY
                                : mediaService.generateMediaUrl(ctx.getSource().getAbsolutePath());
                using(mediaServePathConverter).map(source).setAbsolutePath(StringUtils.EMPTY);
            }
        });

        return modelMapper;

    }
}
