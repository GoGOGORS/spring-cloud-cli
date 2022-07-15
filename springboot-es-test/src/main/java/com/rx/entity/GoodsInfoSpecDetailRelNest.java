package com.rx.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.Convert;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * SKU规格值关联实体类
 * Created by dyt on 2017/4/11.
 */
@Data
public class GoodsInfoSpecDetailRelNest implements Serializable {

    /**
     * SKU与规格值关联ID
     */
    private Long specDetailRelId;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * SKU编号
     */
    private String goodsInfoId;

    /**
     * 规格值ID
     */
    private Long specDetailId;

    /**
     * 规格ID
     */
    private Long specId;

    /**
     * 规格值自定义名称
     * 分词搜索
     */
    @Field(index = FieldIndex.analyzed, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word", type = FieldType.String)
    private String detailName;

    /**
     * 创建时间
     */
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private DeleteFlag delFlag;

    /**
     * 新增商品时，模拟规格ID
     * 表明与SKU的关系
     */
    private Long mockSpecId;

    /**
     * 新增商品时，模拟规格值ID
     * 表明与SKU的关系
     */
    private Long mockSpecDetailId;

    /**
     * 规格项名称
     * 用于存储ES结构
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String specName;

    /**
     * 规格项值
     * 用于存储ES结构，主要解决ES的聚合结果不以分词显示
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String allDetailName;
}
