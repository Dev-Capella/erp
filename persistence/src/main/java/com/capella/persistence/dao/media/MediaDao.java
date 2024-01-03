package com.capella.persistence.dao.media;

import com.capella.domain.enums.MediaCategory;
import com.capella.domain.model.media.MediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaDao extends JpaRepository<MediaModel, Long> {
    List<MediaModel> getByMediaCategory(MediaCategory mediaCategory);
    MediaModel getByCode(String code);
}
