/*
 *   All rights Reserved, Designed By ZTE-ITS
 *   Copyright:    Copyright(C) 2019-2025
 *   Company       JKHH120 LTD.
 *   @Author:    fengzijk
 *   @Email: guozhifengvip@163.com
 *   @Version    V1.0
 *   @Date:   2019年05月20日 12时45分
 *   Modification       History:
 *   ------------------------------------------------------------------------------------
 *   Date                  Author        Version        Discription
 *   -----------------------------------------------------------------------------------
 *  2019-05-20 12:45:09    fengzijk         1.0         Why & What is modified: <修改原因描述>
 *
 *
 */

package com.ch.cb_common.core.mybatis;

import com.ch.cb_common.utils.SnowflakeIdWorker;
import tk.mybatis.mapper.genid.GenId;

/**
 * 自定义雪花算法id生成器
 * @author lch
 * @date 2020/4/12
 */
public class SnowflakeIdGenId implements GenId<Long> {
    @Override
    public Long genId(String s, String s1) {
        return SnowflakeIdWorker.genId();
    }
}
