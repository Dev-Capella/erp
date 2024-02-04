package com.capella.domain.data.treenode;

import lombok.Data;

import java.util.List;

@Data
public class TreeNodeData {
    private String label;
    private String data;
    private List<TreeNodeData> children;
}
