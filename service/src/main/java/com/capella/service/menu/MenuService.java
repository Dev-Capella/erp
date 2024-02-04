package com.capella.service.menu;

import com.capella.domain.model.menu.MenuModel;

import java.util.List;

public interface MenuService {
    MenuModel getMenuModel(String code);
    List<MenuModel> getMenusByRoot();
}
