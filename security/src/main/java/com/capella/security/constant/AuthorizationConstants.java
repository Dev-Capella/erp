package com.capella.security.constant;

import com.capella.base.util.ErpClassUtils;
import com.capella.service.constant.ServiceConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationConstants {

    public static String ADMIN = "admin";
    public static final String READ = "Read";
    public static final String SAVE = "Save";
    public static final String DELETE = "Delete";

    public static String[] generateRoles(String typeName, String role){
        var className = ErpClassUtils.generateClassName(typeName, ServiceConstant.HYPEN, StringUtils.EMPTY);
        return new String[]{className.concat(ServiceConstant.UNDERSCORE).concat(role), ADMIN};
    }
}
