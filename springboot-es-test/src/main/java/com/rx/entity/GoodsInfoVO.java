package com.rx.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品SKU实体类
 * Created by dyt on 2017/4/11.
 */
@Data
public class GoodsInfoVO implements Serializable {

    private static final long serialVersionUID = 3973312626817597962L;

    /**
     * 商品SKU编号
     */
    private String goodsInfoId;

    /**
     * 商品编号
     */
    private String goodsId;

    /**
     * 商品SKU名称
     */
    private String goodsInfoName;

    /**
     * 商品SKU编码
     */
    private String goodsInfoNo;

    /**
     * 商品图片
     */
    private String goodsInfoImg;

    /**
     * 商品条形码
     */
    private String goodsInfoBarcode;

    /**
     * 商品库存
     */
    private Long stock;

    /**
     * 商品市场价
     */
    private BigDecimal marketPrice;

    /**
     * 拼团价
     */
    private BigDecimal grouponPrice;

    /**
     * 商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 上下架时间
     */
    private LocalDateTime addedTime;

    /**
     * 删除标记
     */
    private DeleteFlag delFlag;

    /**
     * 上下架状态
     */
    private Integer addedFlag;

    /**
     * 公司信息ID
     */
    private Long companyInfoId;

    /**
     * 店铺ID
     */
    private Long storeId;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 按客户单独定价
     */
    private Integer customFlag;

    /**
     * 是否叠加客户等级折扣
     */
    private Integer levelDiscountFlag;

    /**
     * 审核状态
     */
    private CheckStatus auditStatus;

    /**
     * 供应商类型 0、平台自营 1、第三方供应商
     */
    private BoolFlag companyType;

    /**
     * 是否独立设价 1:是 0:否
     */
    private Boolean aloneFlag;

    /**
     * 最新计算的会员价
     * 为空，以市场价为准
     */
    private BigDecimal salePrice;

    /**
     * 设价类型 0:客户,1:订货
     */
    private Integer priceType;

    /**
     * 新增时，模拟多个规格ID
     * 查询详情返回响应，扁平化多个规格ID
     */
    private List<Long> mockSpecIds;

    /**
     * 新增时，模拟多个规格值 ID
     * 查询详情返回响应，扁平化多个规格值ID
     */
    private  List<Long> mockSpecDetailIds;

    /**
     * 商品分页，扁平化多个商品规格值ID
     */
    private List<Long> specDetailRelIds;

    /**
     * 购买量
     */
    private Long buyCount = 0L;

    /**
     * 最新计算的起订量
     * 为空，则不限
     */
    private Long count;

    /**
     * 最新计算的限定量
     * 为空，则不限
     */
    private Long maxCount;

    /**
     * 一对多关系，多个订货区间价格编号
     */
    private List<Long> intervalPriceIds;

    /**
     * 规格名称规格值 颜色:红色;大小:16G
     */
    private String specText;

    /**
     * 最小区间价
     */
    private BigDecimal intervalMinPrice;

    /**
     * 最大区间价
     */
    private BigDecimal intervalMaxPrice;

    /**
     * 有效状态 0:无效,1:有效
     */
    private Integer validFlag;

    /**
     * 商品分类ID
     */
    private Long cateId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 多对多关系，多个店铺分类编号
     */
    private List<Long> storeCateIds;

    /**
     * 预估佣金
     */
    private BigDecimal distributionCommission;

    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;

    /**
     * 分销销量
     */
    private Integer distributionSalesCount;

    /**
     * 分销商品审核状态 0:普通商品 1:待审核 2:已审核通过 3:审核不通过 4:禁止分销
     */
    private DistributionGoodsAudit distributionGoodsAudit;

    /**
     * 分销商品审核不通过或禁止分销原因
     */
    private String distributionGoodsAuditReason;

    /**
     * 前端是否选中
     */
    private Boolean checked = false;

    /**
     * 商品状态 0：正常 1：缺货 2：失效
     */
    private GoodsStatus goodsStatus = GoodsStatus.OK;

    /**
     * 计算单位
     */
    private String goodsUnit;

    /**
     * 促销标签
     */
    private List<MarketingLabelVO> marketingLabels = new ArrayList<>();

    /**
     * 拼团标签
     */
    private GrouponLabelVO grouponLabel;
    /**
     * 优惠券标签
     */
    private List<CouponLabelVO> couponLabels = new ArrayList<>();

    /**
     * 商品体积 单位：m3
     */
    private BigDecimal goodsCubage;

    /**
     * 商品重量
     */
    private BigDecimal goodsWeight;

    /**
     * 运费模板ID
     */
    private Long freightTempId;

    /**
     * 销售类型 0:批发, 1:零售
     */
    private Integer saleType;

    /**
     * 是否允许独立设价 0:不允许, 1:允许
     */
    private Integer allowPriceSet;

    /**
     * 商品详情小程序码
     */
    private String  smallProgramCode;

    /**
     * 是否已关联分销员
     *
     */
    private Integer joinDistributior;

    /**
     * 商品评论数
     */
    private Long goodsEvaluateNum;

    /**
     * 商品收藏量
     */
    private Long goodsCollectNum;

    /**
     * 商品销量
     */
    private Long goodsSalesNum;

    /**
     * 商品好评数
     */
    private Long goodsFavorableCommentNum;


    /**
     * 商品类型标识 0 实体商品 1 虚拟商品
     */
    private Integer goodsTypeFlag;
    /**
     * mark图标
     */
    private Integer markImgFlag;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;


    /**
     * 商品角标
     */
    private String goodsMark;

    private Integer taxRate;


}
