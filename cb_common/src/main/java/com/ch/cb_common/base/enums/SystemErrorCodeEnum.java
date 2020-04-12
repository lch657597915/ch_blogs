package com.ch.cb_common.base.enums;

/**
 * 系统状态码,code格式10xxxx
 * @author lch
 * @date 2020/4/12
 */
public enum SystemErrorCodeEnum {

    /**
     *
     * @author lch
     * @date 2020/4/12
     */
    SYS_SUCCESS(100000, "操作成功"),
    SYS_FAIL(100001, "操作失败"),
    SYS_PARAM_DEFECT(100002, "参数缺失"),
    SYS_ILLEGAL_ACCESS(100003, "非法访问"),
    SYS_NEED_LOGIN(100004, "请重新登录"),
    SYS_FORCED_UPGRADE(100005, "APP版本强制升级"),
    SYS_ACCESS_PERMISSION(100006, "无访问权限"),
    SYS_RE_SUBMIT(100007, "请稍后重试"),
    /**
     * 微服务Feign调用异常
     */
    SYS_SERVICE_NETWORK_ERROR(100500, "服务网络异常"),
    /**
     * 微服务Feign调用失败
     */
    SYS_SERVICE_FAIL(100501, "服务调用失败"),
    SYS_ERROR(100999, "操作失败,稍后重试");

    private int code;
    private String msg;

    SystemErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
