package com.capella.facade.media.impl;

import com.capella.domain.data.media.MediaData;
import com.capella.domain.enums.MediaCategory;
import com.capella.facade.media.MediaFacade;
import com.capella.service.media.MediaService;
import com.capella.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Component
@AllArgsConstructor
@Slf4j
public class MediaFacadeImpl implements MediaFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final MediaService mediaService;


    @Override
    public void save(MultipartFile file, MediaCategory mediaCategory) throws IOException {
        mediaService.storage(file, Boolean.TRUE, mediaCategory);
    }
    @Override
    public Set<MediaData> getMediasByMediaCategory(MediaCategory mediaCategory) {
        var mediaModels = mediaService.getMediasByMediaCategory(mediaCategory);
        return Set.of(modelMapper.map(mediaModels, MediaData[].class));
    }
}
