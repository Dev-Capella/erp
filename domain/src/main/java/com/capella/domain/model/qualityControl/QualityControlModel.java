package com.capella.domain.model.qualityControl;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "QualityControl")
@Getter
public class QualityControlModel {

    private String label;

    private Boolean costForQuality;

    private Boolean costForFailedQuality;
}
