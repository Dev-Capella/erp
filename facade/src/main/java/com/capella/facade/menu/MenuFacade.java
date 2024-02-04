package com.capella.facade.menu;

import com.capella.domain.data.menu.MenuData;
import com.capella.domain.data.menu.MenuSummaryData;

import java.util.List;

public interface MenuFacade {
    void save(MenuData menuData);
    List<MenuSummaryData> getMenusByRoot();
    List<MenuSummaryData> getMenuItemsByCode(String code);
}
