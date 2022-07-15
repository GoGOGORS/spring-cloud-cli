package com.rx.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 0未删除 1已删除
 * Created by zhangjin on 2017/3/22.
 */
public enum DeleteFlag {
    NO,
    YES;

    @JsonCreator
    public static DeleteFlag fromValue(int value) {
        return values()[value];
    }

    @JsonValue
    public int toValue() {
        return this.ordinal();
    }
}
