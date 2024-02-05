package com.capella.domain.data.treenode;

import lombok.Data;

import java.util.List;

@Data
public class TreeNodeData {
    private String key;
    private String label;
    private String data;
    private boolean leaf = true;
    private List<TreeNodeData> children;
}
