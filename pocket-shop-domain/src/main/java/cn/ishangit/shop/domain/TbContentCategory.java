package cn.ishangit.shop.domain;

import cn.ishangit.shop.commons.persistence.BaseEntity;

/**
 * @author Chen
 * @create 2019-05-20 14:20
 */
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private  Integer status;
    private Integer sortOrder;
    private boolean isParent;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }
}
