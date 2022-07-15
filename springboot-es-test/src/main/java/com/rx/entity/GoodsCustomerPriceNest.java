package com.rx.entity;


import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

/**
 * 商品客户价格实体
 * Created by dyt on 2017/4/17.
 */
@Data
public class GoodsCustomerPriceNest {

    /**
     * 客户价格ID
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long customerPriceId;

    /**
     * 商品ID
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String goodsId;

    /**
     * 客户ID
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String customerId;

    /**
     * 订货价
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Double)
    private BigDecimal price;

    /**
     * 起订量
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long count;

    /**
     * 限订量
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long maxCount;

    /**
     * 商品ID
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String goodsInfoId;

    /**
     * 类型
     */
    private PriceType type;

}
