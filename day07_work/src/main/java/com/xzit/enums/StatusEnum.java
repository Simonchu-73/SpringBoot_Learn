package com.xzit.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum StatusEnum {
    ACTIVE(0, "已经激活"),
    NO_ACTIVE(1, "未激活");

    StatusEnum(Integer statusValue, String statusDesc) {
        this.statusValue = statusValue;
        this.statusDesc = statusDesc;
    }

    @EnumValue
    private Integer statusValue;
    private String statusDesc;

    @Override
    public String toString() {
        return "statusDesc='" + statusDesc;
    }
}
