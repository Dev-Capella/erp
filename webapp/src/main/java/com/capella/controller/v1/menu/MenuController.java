package com.capella.controller.v1.menu;

import com.capella.constants.ControllerMappings;
import com.capella.domain.data.menu.MenuData;
import com.capella.domain.data.restservice.ServiceResponseData;
import com.capella.domain.enums.ProcessStatus;
import com.capella.facade.menu.MenuFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("menuControllerV1")
@RequestMapping(ControllerMappings.VERSION_V1 + ControllerMappings.MENU)
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    protected final MenuFacade menuFacade;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('Menu_Save')")
    public ServiceResponseData save(@Validated @RequestBody MenuData menuData){
        log.info("Inside save of MenuController",menuData);
        menuFacade.save(menuData);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping(ControllerMappings.CODE)
    @PreAuthorize("hasAnyAuthority('Menu_Read')")
    public ServiceResponseData get(@PathVariable String code){
        log.info("Inside get of MenuController",code);
        var menuData = menuFacade.get(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(menuData);
        return response;
    }

    @GetMapping("/roots")
    @PreAuthorize("hasAnyAuthority('Menu_Read')")
    public ServiceResponseData getMenusByRoot(){
        log.info("Inside getMenusByRoot of MenuController");
        var rootMenuDatas = menuFacade.getMenusByRoot();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(rootMenuDatas);
        return response;
    }

    @GetMapping(ControllerMappings.CODE + "/items")
    @PreAuthorize("hasAnyAuthority('Menu_Read')")
    public ServiceResponseData getMenuItemsByCode(@PathVariable String code){
        log.info("Inside getMenuItemsByCode of MenuController", code);
        var menuItems = menuFacade.getMenuItemsByCode(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(menuItems);
        return response;
    }

    @GetMapping("/tree-node")
    @PreAuthorize("hasAnyAuthority('Menu_Read')")
    public ServiceResponseData getMenusForTreeNode(){
        log.info("Inside getMenusForTreeNode of MenuController");
        var menus = menuFacade.getMenusForTreeNode();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(menus);
        return response;
    }

    @DeleteMapping(ControllerMappings.CODE)
    @PreAuthorize("hasAnyAuthority('Menu_Remove')")
    public ServiceResponseData delete(@PathVariable String code){
        log.info("Inside delete of MenuController",code);
        menuFacade.delete(code);
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        return response;
    }

    @GetMapping("/current-user")
    @PreAuthorize("hasAnyAuthority('Menu_Read')")
    public ServiceResponseData getCurrentUserMenus(){
        log.info("Inside getCurrentUserMenus of MenuController");
        var currentUserMenus = menuFacade.getCurrentUserMenus();
        var response = new ServiceResponseData();
        response.setStatus(ProcessStatus.SUCCESS);
        response.setData(currentUserMenus);
        return response;
    }
}
