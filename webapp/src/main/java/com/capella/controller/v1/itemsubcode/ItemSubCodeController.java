package com.capella.controller.v1.itemsubcode;

import com.capella.constants.ControllerMappings;
import com.capella.facade.itemsubcode.ItemSubCodeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("itemTypeControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.ITEMSUBCODE)
@RequiredArgsConstructor
@Slf4j
public class ItemSubCodeController {

    protected final ItemSubCodeFacade itemSubCodeFacade;
}
