package com.capella.service.media;

import com.capella.domain.data.media.MediaData;
import com.capella.domain.enums.MediaCategory;
import com.capella.domain.model.media.MediaModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface MediaService {
    MediaModel storage(MultipartFile multipartFile, boolean secure, MediaCategory mediaCategory) throws IOException;
    Set<MediaModel> getMediasByMediaCategory(MediaCategory mediaCategory);
    MediaModel getMediaByCode(String code);
}
