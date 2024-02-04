package com.capella.service.menu.impl;

import com.capella.domain.model.menu.MenuModel;
import com.capella.persistence.dao.menu.MenuDao;
import com.capella.service.menu.MenuService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {
    private final MenuDao menuDao;
    @Override
    public MenuModel getMenuModel(String code) {
        var menuModel = menuDao.getByCode(code);
        return menuModel;
    }

    @Override
    public List<MenuModel> getMenusByRoot() {
        return menuDao.getAllByRootOrderByQueueAsc(Boolean.TRUE);
    }
}
