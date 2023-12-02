package com.capella.domain.model.elementcontrol;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "ElementControl")
@Getter
public class ElementControlModel extends CodeBasedModel {

    private String label;

    //Policy is coming
}
