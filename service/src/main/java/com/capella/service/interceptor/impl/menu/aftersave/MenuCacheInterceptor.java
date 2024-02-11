package com.capella.service.interceptor.impl.menu.aftersave;

import com.capella.domain.model.menu.MenuModel;
import com.capella.service.exception.interceptor.InterceptorException;
import com.capella.service.interceptor.AfterSaveInterceptor;
import com.capella.service.interceptor.Interceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@AfterSaveInterceptor(itemType = MenuModel.class)
public class MenuCacheInterceptor implements Interceptor<MenuModel> {

    @Override
    public void invoke(MenuModel model) throws InterceptorException {

    }
}
