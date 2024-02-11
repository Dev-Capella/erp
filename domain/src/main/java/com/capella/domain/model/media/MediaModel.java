package com.capella.domain.model.media;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.enums.MediaCategory;
import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = DomainConstant.MEDIA_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.MEDIA_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.MEDIA_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
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

}
