package com.capella.domain.model.productsubcodevalue;

import com.capella.domain.constant.DomainConstant;
import com.capella.domain.model.extend.CodeBasedModel;
import com.capella.domain.model.itemsubcode.ItemSubCodeModel;
import com.capella.domain.model.itemtype.ItemTypeModel;
import com.capella.domain.model.product.ProductModel;
import com.capella.domain.model.usergenericgroupdetail.UserGenericGroupDetailModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = DomainConstant.PRODUCT_SUB_CODE_VALUE_TABLE_NAME,
        uniqueConstraints = {@UniqueConstraint(name = DomainConstant.PRODUCT_SUB_CODE_VALUE_TABLE_NAME + DomainConstant.UNIQUE_KEYS, columnNames = {CodeBasedModel.Fields.code})},
        indexes = {@Index(name = DomainConstant.PRODUCT_SUB_CODE_VALUE_TABLE_NAME + DomainConstant.CODE_IDX, columnList = "code")})
@Getter
@Setter
public class ProductSubCodeValueModel extends CodeBasedModel {

    public static final String PRODUCT_SUB_CODE_VALUE_RELATION = "product_sub_code_value_id";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name="products_product_sub_code_values",
            joinColumns = @JoinColumn(name = PRODUCT_SUB_CODE_VALUE_RELATION), inverseJoinColumns = @JoinColumn(name = ProductModel.PRODUCT_RELATION))
    private ProductModel product;

    @ManyToOne(fetch = FetchType.LAZY)
    private ItemSubCodeModel itemSubCode;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserGenericGroupDetailModel userGenericGroupDetail;

    private String textValue;

    private BigDecimal numericValue;
}
