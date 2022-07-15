package com.rx.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 数据类型
 * 0：spu数据 1sku数据
 * Created by daiyitian on 2017/3/22.
 */
public enum PriceType {

    SPU,

    SKU;
    @JsonCreator
    public PriceType fromValue(int value) {
        return values()[value];
    }

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
