package com.capella.domain.data.media;

import com.capella.domain.data.base.BaseData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class MediaData extends BaseData {
    private String realFileName;
    private String encodedFileName;
    private String filePath;
    private String rootPath;
    private String servePath;
    private String absolutePath;
    private String mime;
    private String extension;
    private long size;
}
