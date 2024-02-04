package com.capella.facade.menu.impl;

import com.capella.domain.data.menu.MenuData;
import com.capella.domain.data.menu.MenuSummaryData;
import com.capella.domain.data.treenode.TreeNodeData;
import com.capella.domain.model.menu.MenuModel;
import com.capella.domain.model.permission.PermissionModel;
import com.capella.facade.menu.MenuFacade;
import com.capella.service.menu.MenuService;
import com.capella.service.model.ModelService;
import com.capella.service.permission.PermissionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class MenuFacadeImpl implements MenuFacade {
    protected final ModelMapper modelMapper;
    protected final ModelService modelService;
    protected final MenuService menuService;
    protected final PermissionService permissionService;

    @Override
    public void save(MenuData menuData) {
        MenuModel menuModel;
        if (menuData.isNew()) {
            menuModel = modelMapper.map(menuData, MenuModel.class);
            menuModel.setCode(UUID.randomUUID().toString());
        } else {
            menuModel = menuService.getMenuModel(menuData.getCode());
            modelMapper.map(menuData, menuModel);
        }

        Set<PermissionModel> permissions = new HashSet<>();
        if (CollectionUtils.isNotEmpty(menuData.getPermissions())) {
            menuData.getPermissions().forEach(p ->
                    permissions.add(permissionService.getPermissionModel(p.getCode())));
        }
        menuModel.setPermissions(permissions);

        MenuModel parent = null;
        if (Objects.nonNull(menuData.getParent())) {
            parent = menuService.getMenuModel(menuData.getParent().getCode());
        }
        menuModel.setParent(parent);

        modelService.save(menuModel);
    }

    @Override
    public List<MenuSummaryData> getMenusByRoot() {
        var menus = menuService.getMenusByRoot();
        return List.of(modelMapper.map(menus, MenuSummaryData[].class));
    }

    @Override
    public List<MenuSummaryData> getMenuItemsByCode(String code) {
        var menuModel = menuService.getMenuModel(code);
        var menuItems = menuModel.getItems();
        return List.of(modelMapper.map(menuItems, MenuSummaryData[].class));
    }

    @Override
    public List<TreeNodeData> getMenusForTreeNode() {
        var menus = menuService.getMenusByRoot();
        var menuDatas = modelMapper.map(menus, MenuData[].class);

        var treeNodeDatas = new ArrayList<TreeNodeData>();
        Arrays.stream(menuDatas).forEach(m -> {
            var treeNodeData = new TreeNodeData();
            treeNodeData.setLabel(m.getShortText());
            treeNodeData.setData(m.getLongText());
            treeNodeData.setChildren(setChildren(m));
            treeNodeDatas.add(treeNodeData);
        });

        return treeNodeDatas;
    }

    private List<TreeNodeData> setChildren(MenuData menuData){
        var treeNodeDatas = new ArrayList<TreeNodeData>();
        if(CollectionUtils.isNotEmpty(menuData.getItems())){
            for (MenuData m : menuData.getItems()){
                var treeNodeData = new TreeNodeData();
                treeNodeData.setLabel(m.getShortText());
                treeNodeData.setData(m.getLongText());
                treeNodeData.setChildren(setChildren(m));
                treeNodeDatas.add(treeNodeData);
            }
        }
        return treeNodeDatas;
    }
}
