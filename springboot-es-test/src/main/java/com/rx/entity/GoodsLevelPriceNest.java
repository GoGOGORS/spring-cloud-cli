package com.rx.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * 商品级别价格实体
 * Created by dyt on 2017/4/17.
 */
@Data
public class GoodsLevelPriceNest implements Serializable {

    /**
     * 级别价格ID
     */
    private Long levelPriceId;

    /**
     * 商品编号
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String goodsId;

    /**
     * 等级ID
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long levelId;

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
