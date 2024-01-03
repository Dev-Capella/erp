package com.capella.domain.model.media;

import com.capella.domain.enums.MediaCategory;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "Media")
@Getter
public class MediaModel extends CodeBasedModel {

    public static final String MEDIA_RELATION = "media_id";

    private String realFileName;
    private String encodedFileName;
    private String filePath;
    private String rootPath;
    private String servePath;
    private String absolutePath;
    private String mime;
    private String extension;
    private long size;
    private boolean secure;
    private boolean deleted;
    @Enumerated(EnumType.STRING)
    private MediaCategory mediaCategory;

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public void setEncodedFileName(String encodedFileName) {
        this.encodedFileName = encodedFileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public void setServePath(String servePath) {
        this.servePath = servePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setMediaCategory(MediaCategory mediaCategory) {
        this.mediaCategory = mediaCategory;
    }
}
