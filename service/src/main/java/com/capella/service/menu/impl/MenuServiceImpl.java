package com.capella.service.menu.impl;

import com.capella.domain.model.menu.MenuModel;
import com.capella.persistence.dao.menu.MenuDao;
import com.capella.service.menu.MenuService;
import com.capella.service.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {
    protected final UserService userService;
    protected final MenuDao menuDao;
    @Override
    public MenuModel getMenuModel(String code) {
        var menuModel = menuDao.getByCode(code);
        return menuModel;
    }

    @Override
    public List<MenuModel> getMenusByRoot() {
        return menuDao.getAllByRootOrderByQueueAsc(Boolean.TRUE);
    }

    @Override
    public Set<MenuModel> getCurrentUserMenus() {
        var currentUser = userService.getCurrentUser();
        Set<MenuModel> menus =
                menuDao.getAllByRootAndUserRolesInOrderByQueueAsc(Boolean.TRUE, currentUser.getUserRoles());

        Predicate<MenuModel> menuAuthorityPredicate =
                menuModel -> CollectionUtils.containsAny(currentUser.getUserRoles(), menuModel.getUserRoles());
        setMenuRecursive(menus, menuAuthorityPredicate);
        return menus;
    }

    private void setMenuRecursive(Collection<MenuModel> menus, Predicate<MenuModel> menuPredicate){
        menus.forEach(m -> {
            if(CollectionUtils.isNotEmpty(m.getItems())){
                m.getItems().removeIf(item -> !menuPredicate.test(item));
            }
        });

        for (var menu : menus){
            if(CollectionUtils.isEmpty(menu.getItems())){
                menu.setItems(null);
            }else{
                setMenuRecursive(menu.getItems(), menuPredicate);
            }
        }
    }
}
