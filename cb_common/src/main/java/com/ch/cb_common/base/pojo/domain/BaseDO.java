package com.ch.cb_common.base.pojo.domain;


import com.ch.cb_common.core.mybatis.SnowflakeIdGenId;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DO类基类
 * @author lch
 * @date 2020/4/12
 */
@FieldNameConstants
@Data
public class BaseDO implements Serializable {
    @Id
    @KeySql(genId = SnowflakeIdGenId.class)
    protected Long id;
    /**
     * 创建人ID
     */
    protected Long createId;
    /**
     * 创建人名称
     */
    protected String createName;
    /**
     * 创建时间
     */
    @Column(insertable = false)
    protected LocalDateTime createTime;
    /**
     * 更新人ID
     */
    protected Long updateId;
    /**
     * 更新人
     */
    protected String updateName;
    /**
     * 更新时间
     */
    @Column(insertable = false)
    protected LocalDateTime updateTime;
}
