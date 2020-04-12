package com.ch.cb_common.base.pojo.dto;

import com.ch.cb_common.base.constant.SystemConstant;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用页面分页参数，并做非法校验
 * @author lch
 * @date 2020/4/12
 */
@Data
public class PageRequestDTO extends BaseDTO implements Serializable {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页展示多少数据
     */
    private Integer pageSize;

    public Integer getPageNum() {
        if (this.pageNum == null || this.pageNum <= 0) {
            this.pageNum = SystemConstant.DEFAULT_PAGE_NUM;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if (!checkLegalPageSize()) {
            this.pageSize = SystemConstant.DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    /**
     * 只允许出现合法的分页数量
     *
     * @return
     */
    private boolean checkLegalPageSize() {
        if (this.pageSize != null && this.pageSize > 0 && this.pageSize <= SystemConstant.ALLOW_MAX_PAGE_SIZE) {
            return true;
        }
        return false;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
