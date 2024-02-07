package com.capella.service.menu;

import com.capella.domain.model.menu.MenuModel;

import java.util.List;
import java.util.Set;

public interface MenuService {
    MenuModel getMenuModel(String code);
    List<MenuModel> getMenusByRoot();
    Set<MenuModel> getCurrentUserMenus();
}
