package com.ch.cb_common.base.response;

import com.alibaba.fastjson.JSON;
import com.ch.cb_common.base.enums.SystemErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 返回工具类封装
 * @author lch
 * @date 2020/4/12
 */
@Slf4j
public class ResponseWrap<T> {
    /**
     * 返回成功数据
     *
     * @param data
     * @return
     * @Title: success
     * @description: <功能详细描述>
     * @author gaomingjie
     * @date 2017年5月2日 下午6:39:43
     * @see [类、类#方法、类#成员]
     */
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> rr = new ResponseResult<>();
        rr.setCode(SystemErrorCodeEnum.SYS_SUCCESS.getCode());
        rr.setMsg(SystemErrorCodeEnum.SYS_SUCCESS.getMsg());
        rr.setData(data);
        return rr;
    }


    /**
     * 返回错误数据
     * @author lch
     * @date 2020/4/12
     */
    public static ResponseResult<String> error(int code, String msg) {
        ResponseResult<String> rr = new ResponseResult<>();
        rr.setCode(code);
        rr.setMsg(msg);
        return rr;
    }

    /**
     * 返回失败数据
     * @author lch
     * @date 2020/4/12
     */
    public static <T> ResponseResult<T> fail(T data) {
        ResponseResult<T> rr = new ResponseResult<>();
        rr.setCode(SystemErrorCodeEnum.SYS_FAIL.getCode());
        rr.setMsg(SystemErrorCodeEnum.SYS_FAIL.getMsg());
        rr.setData(data);
        return rr;
    }

    /**
     * 根据Boolean值动态返回true或false
     * @author lch
     * @date 2020/4/12
     */
    public static <T> ResponseResult<T> result(T result) {
        if (result instanceof Boolean && (Boolean) result) {
            return success(result);
        }
        return fail(result);
    }

    public static <T> ResponseResult<T> info(int code, String msg, T data) {
        ResponseResult<T> rr = new ResponseResult<>();
        rr.setCode(code);
        rr.setMsg(msg);
        rr.setData(data);
        return rr;
    }

    public static void info(HttpServletResponse response, ResponseResult<?> result) {
        PrintWriter out = null;
        try {
            if (response != null) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json;charset=utf-8");
                out = response.getWriter();
                out.print(JSON.toJSONString(result));
            }
        } catch (Exception e) {
            log.error("封装JSON异常,异常信息:{}", e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
