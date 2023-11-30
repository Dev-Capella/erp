package com.capella.domain.model.elementControl;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ElementControl")
@Getter
public class ElementControlModel {

    private String label;

    //Policy is coming
}
