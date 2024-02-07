package com.capella.facade.menu;

import com.capella.domain.data.menu.MenuData;
import com.capella.domain.data.menu.MenuSummaryData;
import com.capella.domain.data.treenode.TreeNodeData;

import java.util.List;

public interface MenuFacade {
    void save(MenuData menuData);
    List<MenuSummaryData> getMenusByRoot();
    List<MenuSummaryData> getMenuItemsByCode(String code);
    List<TreeNodeData> getMenusForTreeNode();
    MenuData get(String code);
    void delete(String code);
}
