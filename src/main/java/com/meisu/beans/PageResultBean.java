package com.meisu.beans;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Administrator
 * 分页返回数据
 */
@Getter
@NoArgsConstructor
public class PageResultBean<T> extends ResultBean<T> implements Serializable {
    /**
     * 总页数
     */
    private long pageCount;

    /**
     * 总记录数
     */
    private long totalRecord;
    /**
     * 当前页码
     */
    private long pageNo;


    public PageResultBean(IPage<T> pageInfo) {
        super.setData((T) pageInfo.getRecords());
        this.setPageCount(pageInfo.getSize())
                .setTotalRecord(pageInfo.getTotal())
                .setPageNo(pageInfo.getCurrent());
    }

    public PageResultBean setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        return this;
    }

    public PageResultBean setPageCount(long pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public PageResultBean setPageNo(long pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    @Override
    public String toString() {
        return "PageResultBean{" +
                "pageCount=" + pageCount +
                ", totalRecord=" + totalRecord +
                ", pageNo=" + pageNo +
                '}';
    }

    @Override
    public PageResultBean setMsg(String msg) {
        super.setMsg(msg);
        return this;
    }

    @Override
    public PageResultBean setCode(int code) {
        super.setCode(code);
        return this;
    }

    @Override
    public PageResultBean setData(T data) {
        super.setData(data);
        return this;
    }
}
