package com.capella.domain.model.qualitylevel;

import com.capella.domain.model.extend.CodeBasedModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "QualityLevel")
@Getter
public class QualityLevelModel extends CodeBasedModel {

    private int level;

    private String longText;

    private String shortText;

    private String searchText;
}
