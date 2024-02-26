package com.capella.facade.policy.impl.itemsubcodechecktype;

import com.capella.domain.data.itemsubcode.ItemSubCodeData;
import com.capella.domain.data.itemsubcodechecktype.PLItemSubCodeCheckTypeData;
import com.capella.domain.data.usergenericgroup.UserGenericGroupData;
import com.capella.domain.model.usergenericgroup.UserGenericGroupModel;
import com.capella.facade.policy.PolicyEvaluate;
import com.capella.facade.policy.Policy;
import com.capella.service.usergenericgroup.UserGenericGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.util.Set;

@Policy
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeCheckTypeUserGenericGroupPolicy implements PolicyEvaluate<PLItemSubCodeCheckTypeData> {

    /*
    Item sub code checktype seçimi yapılan yerde sağlanması gereken alan;
     */

    protected final UserGenericGroupService userGenericGroupService;
    protected final ModelMapper modelMapper;

    @Override
    public PLItemSubCodeCheckTypeData invoke() {
        PLItemSubCodeCheckTypeData plItemSubCodeCheckTypeData = new PLItemSubCodeCheckTypeData();
        Set<UserGenericGroupModel> userGenericGroupModels = userGenericGroupService.getUserGenericGroupModels();
        plItemSubCodeCheckTypeData.setData(Set.of(modelMapper.map(userGenericGroupModels, UserGenericGroupData[].class)));
        plItemSubCodeCheckTypeData.setLabel("User Generic Group");
        return plItemSubCodeCheckTypeData;
    }
}
