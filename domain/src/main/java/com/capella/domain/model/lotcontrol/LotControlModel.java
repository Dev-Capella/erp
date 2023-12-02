package com.capella.domain.model.lotcontrol;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "LotControl")
@Getter
public class LotControlModel extends CodeBasedModel {
    private String label;

    //Policy is coming
}
