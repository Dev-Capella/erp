package com.capella.service.cachekey;

import com.capella.service.constant.ServiceConstant;
import com.capella.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@RequiredArgsConstructor
public class JWTIDKeyGenerator implements KeyGenerator {

    protected final UserService userService;


    @Override
    public Object generate(Object target, Method method, Object... params) {
        return String.join(ServiceConstant.UNDERSCORE, userService.getCurrentUserJWTId()
                + userService.getCurrentUser().getUsername());
    }
}
