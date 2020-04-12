package com.ch.cb_common.base.response;


import com.ch.cb_common.base.enums.SystemErrorCodeEnum;
import lombok.Data;
import lombok.ToString;

/**
 * 返回数据封装
 * @author lch
 * @date 2020/4/12
 */
@Data
public class ResponseResult<T> {

    private int code;
    private String msg;
    private T data;
    private boolean success;

    public boolean isSuccess() {
        this.success = this.code == SystemErrorCodeEnum.SYS_SUCCESS.getCode();
        return success;
    }
}
