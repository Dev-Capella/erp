package com.capella.facade.config;

import com.capella.domain.data.compositiondetail.CompositionDetailData;
import com.capella.domain.data.counter.CounterData;
import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.manufacturer.ManufacturerData;
import com.capella.domain.data.media.MediaData;
import com.capella.domain.data.menu.MenuData;
import com.capella.domain.data.product.ProductData;
import com.capella.domain.data.productiongroup.ProductionGroupData;
import com.capella.domain.data.subseries.SubSeriesData;
import com.capella.domain.data.user.UserData;
import com.capella.domain.data.userrole.UserRoleData;
import com.capella.domain.data.washsymbol.WashSymbolData;
import com.capella.domain.model.compositiondetail.CompositionDetailModel;
import com.capella.domain.model.counter.CounterModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.manufacturer.ManufacturerModel;
import com.capella.domain.model.media.MediaModel;
import com.capella.domain.model.menu.MenuModel;
import com.capella.domain.model.product.ProductModel;
import com.capella.domain.model.productiongroup.ProductionGroupModel;
import com.capella.domain.model.subseries.SubSeriesModel;
import com.capella.domain.model.user.UserModel;
import com.capella.domain.model.userrole.UserRoleModel;
import com.capella.domain.model.washsymbol.WashSymbolModel;
import com.capella.service.media.MediaService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Conditions;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@RequiredArgsConstructor
public class FacadeConfig {
    protected final MediaService mediaService;

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
        modelMapper.addMappings(new PropertyMap<ProductionGroupData, ProductionGroupModel>() {
            @Override
            protected void configure() {
                skip(destination.getItemType());
            }
        });
        modelMapper.addMappings(new PropertyMap<ManufacturerData, ManufacturerModel>() {
            @Override
            protected void configure() {
                skip(destination.getMedia());
            }
        });

        modelMapper.addMappings(new PropertyMap<ProductData, ProductModel>() {
            @Override
            protected void configure() {
                skip(destination.getPrimaryUOM());
                skip(destination.getCostUOM());
                skip(destination.getSecondaryUOM());
                skip(destination.getManufacturer());
                skip(destination.getCostCategory());
                skip(destination.getCostLevel());
                skip(destination.getProductionGroup());
                skip(destination.getCompositionModel());
                skip(destination.getItemType());
            }
        });
        modelMapper.addMappings(new PropertyMap<MenuData, MenuModel>() {
            @Override
            protected void configure() {
                skip(destination.getParent());
                skip(destination.getPermissions());
                skip(destination.getUserRoles());
                skip(destination.getItems());
            }
        });

        modelMapper.addMappings(new PropertyMap<ItemSubCodeData, ItemSubCodeModel>() {
            @Override
            protected void configure() {
                skip(destination.getItemSubCodeCheckType());
                skip(destination.getUserGenericGroup());
            }
        });

        modelMapper.addMappings(new PropertyMap<UserData, UserModel>() {
            @Override
            protected void configure() {
                skip(destination.getUserRoles());
            }
        });
        modelMapper.addMappings(new PropertyMap<UserRoleData, UserRoleModel>() {
            @Override
            protected void configure() {
                skip(destination.getPermissions());
            }
        });
        modelMapper.addMappings(new PropertyMap<WashSymbolData, WashSymbolModel>() {
            @Override
            protected void configure() {
                skip(destination.getWashSymbolCategory());
            }
        });
        modelMapper.addMappings(new PropertyMap<CounterData, CounterModel>() {
            @Override
            protected void configure() {
                skip(destination.getCounterType());
            }
        });
        modelMapper.addMappings(new PropertyMap<SubSeriesData, SubSeriesModel>() {
            @Override
            protected void configure() {
                skip(destination.getCounter());
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
