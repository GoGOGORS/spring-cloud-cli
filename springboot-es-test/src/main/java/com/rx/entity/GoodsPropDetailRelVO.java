package com.rx.entity;

import lombok.Data;

import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ${DESCRIPTION}
 *
 * @auther ruilinxin
 * @create 2018/03/20 10:04
 */
@Data
public class GoodsPropDetailRelVO implements Serializable {

    private static final long serialVersionUID = -7826451740574928116L;

    /**
     * 编号，
     */
    private Long relId;

    /**
     * SPU标识
     */
    private String goodsId;

    /**
     * 属性值id
     */
    private Long detailId;

    /**
     * 属性id
     */
    private Long propId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 删除标记
     */
    @Enumerated
    private DeleteFlag delFlag;
}
