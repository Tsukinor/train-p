package com.jiawa.train.common.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @program: train
 * @author: Jeffrey
 * @create: 2024-03-03 12:16
 * @description: 分页查询结果返回封装类。使用时将业务结果List<XXXResp>放入即可
 **/
public class PageResp<T> implements Serializable{
    // 总条数
    private Long total;

    // 当前页的列表
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
