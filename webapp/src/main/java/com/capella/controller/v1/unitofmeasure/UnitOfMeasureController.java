package com.capella.controller.v1.unitofmeasure;

import com.capella.constants.ControllerMappings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("unitOfMeasureControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.UNITOFMEASURE)
@RequiredArgsConstructor
@Slf4j
public class UnitOfMeasureController {
}
