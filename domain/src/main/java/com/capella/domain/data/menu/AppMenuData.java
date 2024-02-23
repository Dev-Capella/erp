package com.capella.domain.data.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AppMenuData implements Serializable {
    private String label;
    private String icon;
    private List<String> routerLink;
    private List<AppMenuData> items;
}
