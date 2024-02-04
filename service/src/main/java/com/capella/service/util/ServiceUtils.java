package com.capella.service.util;

import com.capella.domain.model.extend.CodeBasedModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

@Slf4j
public class ServiceUtils {
    public static <T extends CodeBasedModel> T generateCodeIfMissing(T t){
        t.setCode(StringUtils.isEmpty(t.getCode()) ? UUID.randomUUID().toString() : t.getCode());
        return t;
    }
}
