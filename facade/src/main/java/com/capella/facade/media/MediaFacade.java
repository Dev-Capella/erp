package com.capella.facade.media;

import com.capella.domain.data.media.MediaData;
import com.capella.domain.enums.MediaCategory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface MediaFacade {
    void save(MultipartFile file, MediaCategory mediaCategory) throws IOException;
    Set<MediaData> getMediasByMediaCategory(MediaCategory mediaCategory);
}
