package com.capella.domain.model.containerControl;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ContainerControl")
@Getter
public class ContainerControlModel {

    private String label;

    //Policy is coming
}
