package com.capella.domain.model.lotControl;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "LotControl")
@Getter
public class LotControlModel {
    private String label;

    //Policy is coming
}
