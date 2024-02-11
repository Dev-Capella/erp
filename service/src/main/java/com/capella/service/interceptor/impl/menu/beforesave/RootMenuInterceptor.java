package com.capella.service.interceptor.impl.menu.beforesave;


import com.capella.domain.model.menu.MenuModel;
import com.capella.service.exception.interceptor.InterceptorException;
import com.capella.service.interceptor.BeforeSaveInterceptor;
import com.capella.service.interceptor.Interceptor;

import java.util.Objects;


@BeforeSaveInterceptor(itemType = MenuModel.class)
public class RootMenuInterceptor implements Interceptor<MenuModel> {
    /*
        Root menü kaydedilirken aynı zamanda bir parent menü kaydedilirse bu interceptor buna engel olacaktır.
     */
    @Override
    public void invoke(MenuModel model) throws InterceptorException {
        if(model.isRoot() && Objects.nonNull(model.getParent())){
            throw new InterceptorException("Root menu can not have parent",null,null);
        }
    }
}
