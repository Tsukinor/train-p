package com.jiawa.train.common.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2024-03-03 11:53
 **/
public class PageReq {
    @NotNull(message = "页码不能为空")
    private Integer startPage;

    @NotNull(message = "每页条数不能为空")
    // 后端参数校验，防止前端传入过大参数
    @Max(value = 100, message = "每页条数不能超过100")
    private Integer pageSize;

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "page=" + startPage +
                ", size=" + pageSize +
                '}';
    }
}
