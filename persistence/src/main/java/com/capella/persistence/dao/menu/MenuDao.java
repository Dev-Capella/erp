package com.capella.persistence.dao.menu;

import com.capella.domain.model.menu.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDao extends JpaRepository<MenuModel, Long> {
    MenuModel getByCode(String code);
    List<MenuModel> getAllByRootOrderByQueueAsc(Boolean isRoot);
}
