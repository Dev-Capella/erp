package com.capella.facade.policy.impl.itemsubcodechecktype;

import com.capella.domain.data.itemsubcodechecktype.PLItemSubCodeCheckTypeData;
import com.capella.domain.data.itemtype.ItemTypeData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.enums.ItemNature;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.facade.policy.PolicyEvaluate;
import com.capella.service.itemtype.ItemTypeService;
import com.capella.facade.policy.Policy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Policy
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypePolicy implements PolicyEvaluate<PLItemSubCodeCheckTypeData> {

    /*
    Item sub code checktype seçimi yapılan yerde sağlanması gereken alan;
     */

    protected final ItemTypeService itemTypeService;
    protected final ModelMapper modelMapper;

    @Override
    public PLItemSubCodeCheckTypeData invoke() {
        PLItemSubCodeCheckTypeData plItemSubCodeCheckTypeData = new PLItemSubCodeCheckTypeData();
        List<ItemTypeModel> designItemTypes = itemTypeService.getItemTypeModels()
                .stream()
                .filter(item -> ItemNature.DESIGN.equals(item.getItemNature()))
                .collect(Collectors.toList());
        plItemSubCodeCheckTypeData.setData(List.of(modelMapper.map(designItemTypes, ItemTypeData[].class)));
        plItemSubCodeCheckTypeData.setLabel("itemType");
        return plItemSubCodeCheckTypeData;
    }
}
