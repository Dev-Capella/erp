package com.capella.domain.data.menu;

import lombok.Data;

import java.util.List;

@Data
public class AppMenuData {
    private String label;
    private String icon;
    private List<String> routerLink;
    private List<AppMenuData> items;
}
