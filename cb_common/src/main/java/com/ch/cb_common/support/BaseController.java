package com.ch.cb_common.support;

import com.ch.cb_common.base.enums.SystemErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class BaseController  {

    public final String HTTP_POST = "POST";
    public final String HTTP_GET = "GET";

    @Resource
    private HttpServletRequest request;




}