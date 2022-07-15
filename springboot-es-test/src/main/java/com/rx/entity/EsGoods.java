package com.rx.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * ES商品实体类
 * 以SKU维度
 * Created by dyt on 2017/4/21.
 */
@Document(indexName = "s2b", type = "es_goods" )
@Data
public class EsGoods implements Serializable {

    @Id
    private String id;

    /**
     * 转化为小写
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.String)
    private String lowGoodsName;

    /**
     * SKU信息
     */
    private List<GoodsInfoVO> goodsInfos;

    /**
     * 父子关系-分类品牌ID
     * TODO ES 2.X 不支持@Parent，采用父子类型同时定制
     */
//    @Parent(type= EsConstants.DOC_CATE_BRAND_TYPE)
    private String cateBrandId;

    /**
     * 上下架时间
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime addedTime;

    /**
     * SKU相关规格
     */
    @Field(type = FieldType.Nested)
    private List<GoodsInfoSpecDetailRelNest> specDetails;

    /**
     * 多对多关系，SPU相关属性
     */
    @Field(type = FieldType.Nested)
    private List<GoodsPropDetailRelVO> propDetails;

    /**
     * 等级价数据
     */
    private List<GoodsLevelPriceNest> goodsLevelPrices = new ArrayList<>();

    /**
     * 客户价数据
     */
    private List<GoodsCustomerPriceNest> customerPrices = new ArrayList<>();

    /**
     * 签约开始日期
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime contractStartDate;

    /**
     * 签约结束日期
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime contractEndDate;

    /**
     * 店铺状态 0、开启 1、关店
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Integer)
    private Integer storeState;

    /**
     * 禁售状态
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Integer)
    private Integer forbidStatus;

    /**
     * 审核状态
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Integer)
    private Integer auditStatus;

    /**
     * 多对多关系，多个店铺分类编号
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private List<Long> storeCateIds;

    /**
     * 营销信息
     */
    // private List<MarketingForEndVO> marketingList = new ArrayList<>();

    /**
     * 分销商品状态，配合分销开关使用
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Integer)
    private Integer distributionGoodsStatus;

    /**
     * 商品评论数
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long goodsEvaluateNum;

    /**
     * 商品收藏量
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long goodsCollectNum;

    /**
     * 商品销量
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long goodsSalesNum;

    /**
     * 商品好评数量
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long goodsFavorableCommentNum;

    /**
     * 商品好评率
     */
    @Field(index = FieldIndex.not_analyzed, type = FieldType.Long)
    private Long goodsFeedbackRate;
}
