package com.ch.cb_common.base.enums;


/**
 *
 * @author lch
 * @date 2020/4/12
 */
public enum DeleteFlagEnum {

    /**
     * 已删除
     */
    DELETE(1, "已删除"),
    /**
     * 未删除
     */
    UNDELETE(0, "未删除");

    private Integer code;
    private String name;

    DeleteFlagEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getEnum(Integer code) {
        for (DeleteFlagEnum ele : DeleteFlagEnum.values()) {
            if (code.equals(ele.getCode())) {
                return ele.name;
            }
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static DeleteFlagEnum getByCode(int deleteFlag) {
        for (DeleteFlagEnum e : values()) {
            if (e.getCode() == deleteFlag) {
                return e;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer name) {
        if(name != null){
            for (DeleteFlagEnum e : values()) {
                if (e.getCode().equals(name)) {
                    return e.name;
                }
            }
        }
        return null;
    }
}
