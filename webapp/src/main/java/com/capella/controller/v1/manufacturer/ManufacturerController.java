package com.capella.controller.v1.manufacturer;

import com.capella.constants.ControllerMappings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("manufacturerControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.MANUFACTURER)
@RequiredArgsConstructor
@Slf4j
public class ManufacturerController {
}
