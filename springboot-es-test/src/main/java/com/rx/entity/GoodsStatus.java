package com.rx.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 商品状态 0：正常 1：缺货 2：失效
 * Created by Daiyitian on 2017/4/13.
 */
public enum GoodsStatus {

    OK,

    OUT_STOCK,

    INVALID;
    @JsonCreator
    public GoodsStatus fromValue(int value) {
        return values()[value];
    }

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
