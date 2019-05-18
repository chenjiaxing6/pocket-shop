package cn.ishangit.shop.commons.dto;

import cn.ishangit.shop.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Chen
 * @create 2019-05-18 21:53
 * 分页数据传输对象
 * 限制泛型对象必须继承baseEntity
 */
public class PageInfo<T extends BaseEntity> implements Serializable {
    private int draw;
    private List<T> data;
    private int recordsTotal;
    private int recordsFiltered;
    private  String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
