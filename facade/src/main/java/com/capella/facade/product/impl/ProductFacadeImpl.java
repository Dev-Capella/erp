package com.capella.facade.product.impl;

import com.capella.domain.data.product.ProductData;
import com.capella.domain.model.product.ProductModel;
import com.capella.facade.product.ProductFacade;
import com.capella.service.composition.CompositionService;
import com.capella.service.costcategory.CostCategoryService;
import com.capella.service.costlevel.CostLevelService;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.service.manufacturer.ManufacturerService;
import com.capella.service.model.ModelService;
import com.capella.service.product.ProductService;
import com.capella.service.productiongroup.ProductionGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Component
@AllArgsConstructor
@Slf4j
public class ProductFacadeImpl implements ProductFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final ProductService productService;
    protected final ManufacturerService manufacturerService;
    protected final CostCategoryService costCategoryService;
    protected final CostLevelService costLevelService;
    protected final ProductionGroupService productionGroupService;
    protected final CompositionService compositionService;
    protected final ItemTypeService itemTypeService;

    @Override
    public void save(ProductData productData) {
        ProductModel productModel;
        if(productData.isNew()){
            productModel = modelMapper.map(productData, ProductModel.class);
            productModel.setCode(UUID.randomUUID().toString());
        }else{
            productModel = productService.getProductModel(productData.getCode());
            modelMapper.map(productData, productModel);
        }
        if(Objects.nonNull(productData.getManufacturer())){
            var manufacturerModel = manufacturerService.getManufacturerModel(productData.getManufacturer().getCode());
            productModel.setManufacturer(manufacturerModel);
        }
        if(Objects.nonNull(productData.getCostCategory())){
            var costCategoryModel = costCategoryService.getCostCategoryModel(productData.getCostCategory().getCode());
            productModel.setCostCategory(costCategoryModel);
        }
        if(Objects.nonNull(productData.getCostLevel())){
            var costLevelModel = costLevelService.getCostLevelModel(productData.getCostLevel().getCode());
            productModel.setCostLevel(costLevelModel);
        }
        if(Objects.nonNull(productData.getProductionGroup())){
            var productionGroupModel = productionGroupService.getProductionGroupModel(productData.getProductionGroup().getCode());
            productModel.setProductionGroup(productionGroupModel);
        }
        if(Objects.nonNull(productData.getComposition())){
            var compositionModel = compositionService.getCompositionModel(productData.getComposition().getCode());
            productModel.setCompositionModel(compositionModel);
        }
        if(Objects.nonNull(productData.getItemType())){
            var itemTypeModel = itemTypeService.getItemTypeModel(productData.getItemType().getCode());
            productModel.setItemType(itemTypeModel);
        }
        modelService.save(productModel);
    }

    @Override
    public Set<ProductData> getAll() {
        var productModels = productService.getProductModels();
        return Set.of(modelMapper.map(productModels, ProductData[].class));
    }

    @Override
    public ProductData get(String code) {
        var productModel = productService.getProductModel(code);
        return modelMapper.map(productModel,ProductData.class);
    }

    @Override
    public void delete(String code) {
        var productModel = productService.getProductModel(code);
        modelService.remove(productModel);
    }
}
