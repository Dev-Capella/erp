package com.capella.controller.v1.qualitylevel;

import com.capella.constants.ControllerMappings;
import com.capella.facade.qualitylevel.QualityLevelFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("qualityLevelControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.QUALITYLEVEL)
@RequiredArgsConstructor
@Slf4j
public class QualityLevelController {

    protected final QualityLevelFacade qualityLevelFacade;

}
