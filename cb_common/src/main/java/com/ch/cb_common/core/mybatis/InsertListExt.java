/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       JKHH120 LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2019年05月20日 12时42分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2019-05-20 12:42:26    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.ch.cb_common.core.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * 扩展TKMapper 插入时插入非空字段
 * @author lch
 * @date 2020/4/12
 */
@RegisterMapper
public interface InsertListExt<T> {


    /**
     * 扩展批量插入 （处理id问题）
     * @author lch
     * @date 2020/4/12
     */
    @InsertProvider(type = InsertListExtProvider.class, method = "dynamicSQL")
    int insertListExt(List<? extends T> recordList);


}

