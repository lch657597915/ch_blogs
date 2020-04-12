package com.ch.cb_common.core.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mapper封装类
 * @author lch
 * @date 2020/4/12
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>,InsertListExt<T> {
}
