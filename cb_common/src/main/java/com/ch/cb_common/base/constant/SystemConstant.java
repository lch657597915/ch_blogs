package com.ch.cb_common.base.constant;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * SystemConstant
 * @author lch
 * @date 2020/4/12
 */
public class SystemConstant {
    /**
     * UTF-8编码
     */
    public static final String UTF_8_CHARSET = "UTF-8";
    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 默认分页数量
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 最大分页数量
     */
    public static final int ALLOW_MAX_PAGE_SIZE = 100;

    /**
     * 默认日期时间格式
     */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认日期时间格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";


    /**
     * MQ 发送消息超时时间，单位毫秒
     */
    public static String MQ_SEND_MSG_TIMEOUT_MILLIS = "3000";

    /**
     * 操作正确结果返回
     */
    public static final boolean OPERATE_SUCCESS_RESULT = true;
    /**
     * 操作失败结果返回
     */
    public static final boolean OPERATE_FAIL_RESULT = false;

    /**
     * 超级管理员Id
     */
    public static final Long ADMIN_MANAGER_ID = 298606795386130432L;

    /**
     * 系统用户Id
     */
    public static final Long SYSTEM_USER_ID = ADMIN_MANAGER_ID;

    /**
     * 系统用户名称
     */
    public static final String SYSTEM_USER_NAME = "admin";

    /**
     * 网关跳过指定关键字
     */
    public static final String GATEWAY_EXCLUDE_KEY = "exclude";

    /**
     * 后台管理登录有效期
     */
    public static final Long MANAGER_LOGIN_EXPIRE = new Long(60 * 60 * 24);

    /**
     * 环境变量
     */
    public static String SPRING_PROFILES_ACTIVE = "";

}
