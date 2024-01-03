package com.capella.controller.v1.media;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.MediaCategory;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.media.MediaFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("mediaControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.MEDIA)
@RequiredArgsConstructor
@Slf4j
public class MediaController {

    protected final MediaFacade mediaFacade;

    @PostMapping("/{mediaCategory}/upload")
    public ServiceResponseData save(
                                    @Validated @RequestPart(value = "upload") MultipartFile file,
                                    @Validated @PathVariable String mediaCategory) throws IOException {
        log.info("Inside save of MediaController",file);
        var category = MediaCategory.valueOf(mediaCategory.toUpperCase());
        mediaFacade.save(file, category);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping("/{mediaCategory}")
    public ServiceResponseData getMediasByMediaCategory(@Validated @PathVariable String mediaCategory){
        log.info("Inside getMediasByMediaCategory of MediaController",mediaCategory);
        var category = MediaCategory.valueOf(mediaCategory.toUpperCase());
        var medias = mediaFacade.getMediasByMediaCategory(category);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(medias);
        return response;
    }
}
