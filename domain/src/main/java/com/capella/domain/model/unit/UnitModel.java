package com.capella.domain.model.unit;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "UnitModel")
@Getter
public class UnitModel extends CodeBasedModel {

    private String description;
}
