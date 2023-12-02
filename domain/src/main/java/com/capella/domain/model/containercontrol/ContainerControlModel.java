package com.capella.domain.model.containercontrol;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ContainerControl")
@Getter
public class ContainerControlModel extends CodeBasedModel {

    private String label;

    //Policy is coming
}
