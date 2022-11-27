package com.Lql.SRTP.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderItemTypeEnum {

    OUT(1, "出库"),
    IN(2, "入库"),
    ALL(3, "全选"),
    ;

    private Integer code;
    private String msg;

    public static boolean checkTypeValid(Integer type) {
        for (OrderItemTypeEnum typeEnum : OrderItemTypeEnum.values()) {
            if (typeEnum.code.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static OrderItemTypeEnum getItemTypeFromCode(Integer code) {
        for (OrderItemTypeEnum typeEnum : OrderItemTypeEnum.values()) {
            if (typeEnum.code.equals(code)) {
                return typeEnum;
            }
        }
        return null;
    }
}
