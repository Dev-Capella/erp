package com.capella.domain.model.qualitycontrol;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "QualityControl")
@Getter
public class QualityControlModel extends CodeBasedModel {

    private String label;

    private Boolean costForQuality;

    private Boolean costForFailedQuality;
}
