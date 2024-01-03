package com.capella.service.media.impl;

import com.capella.domain.enums.MediaCategory;
import com.capella.domain.model.media.MediaModel;
import com.capella.persistence.dao.media.MediaDao;
import com.capella.service.media.MediaService;
import com.capella.service.model.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MediaServiceImpl implements MediaService {

    protected final ModelService modelService;
    protected final MediaDao mediaDao;

    protected static final char DOT = '.';
    protected static final char SLASH = '/';
    protected static final char UNDERSCORE = '_';
    protected static final String DATE_FORMAT = "yyyyMMdd";
    protected static final String TIME_FORMAT = "HHmmss";
    protected static final String MEDIA_PATTERN = "/media";

    @Value("${media.folder.public.path}")
    protected String publicMediaFolder;
    @Value("${media.folder.root.path}")
    protected String mediaRootPath;
    @Value("${media.folder.private.path}")
    protected String secureMediaFolder;
    @Value("${media.folder.serve.path}")
    protected String mediaServePath;

    @Override
    public MediaModel storage(MultipartFile multipartFile, boolean secure, MediaCategory mediaCategory) throws IOException {
        try {
            var localDateTime = LocalDateTime.now();
            var todayDate = localDateTime.toLocalDate().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
            var todayTime = localDateTime.toLocalTime().format(DateTimeFormatter.ofPattern(TIME_FORMAT));

            var rootPath = Path.of(mediaRootPath).toString();
            var filePath = StringUtils.join(secure ? secureMediaFolder : publicMediaFolder, SLASH, todayDate, SLASH, todayTime);

            var fullPath = StringUtils.join(rootPath, filePath);

            Files.createDirectories(Path.of(fullPath));

            var fileNameHash = RandomStringUtils.random(15, true, true);
            var destFilePath = fullPath + File.separator + fileNameHash + DOT + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            multipartFile.transferTo(new File(FilenameUtils.separatorsToSystem(destFilePath)));

            MediaModel mediaModel = new MediaModel();
            mediaModel.setCode(UUID.randomUUID().toString());
            mediaModel.setRealFileName(FilenameUtils.getName(multipartFile.getOriginalFilename()));
            mediaModel.setEncodedFileName(fileNameHash);
            mediaModel.setExtension(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
            mediaModel.setFilePath(filePath);
            mediaModel.setRootPath(rootPath);
            mediaModel.setSize(multipartFile.getSize());
            mediaModel.setMime(multipartFile.getContentType());
            mediaModel.setSecure(secure);
            mediaModel.setMediaCategory(mediaCategory);

            var absolutePath = StringUtils.join(
                    mediaModel.getFilePath(),SLASH,
                    mediaModel.getEncodedFileName(),DOT,
                    mediaModel.getExtension());
            mediaModel.setAbsolutePath(absolutePath);
            mediaModel.setServePath(StringUtils.replace(absolutePath,MEDIA_PATTERN,StringUtils.EMPTY));
            modelService.save(mediaModel);
            return mediaModel;

        }catch (Exception e){
            log.error(e.getMessage());
            throw new IOException(e.getMessage());
        }

    }

    @Override
    public Set<MediaModel> getMediasByMediaCategory(MediaCategory mediaCategory) {
        List<MediaModel> mediaModels = mediaDao.getByMediaCategory(mediaCategory);
        Set<MediaModel> mediaModelSet = new HashSet<>(mediaModels);
        return mediaModelSet;
    }

    @Override
    public MediaModel getMediaByCode(String code) {
        var mediaModel = mediaDao.getByCode(code);
        return mediaModel;
    }
}
