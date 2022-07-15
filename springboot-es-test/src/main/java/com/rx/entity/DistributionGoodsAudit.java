package com.rx.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 分销商品审核状态 0:普通商品 1:待审核 2:已审核通过 3:审核不通过 4:禁止分销
 * Created by CHENLI
 */
public enum DistributionGoodsAudit {
    COMMON_GOODS,

    WAIT_CHECK,

    CHECKED,

    NOT_PASS,

    FORBID;

    @JsonCreator
    public DistributionGoodsAudit fromValue(int value) {
        return values()[value];
    }

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
