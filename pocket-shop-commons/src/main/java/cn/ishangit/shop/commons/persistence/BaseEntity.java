package cn.ishangit.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chen
 * @create 2019-05-18 21:56
 */
public  abstract  class BaseEntity  implements Serializable {
    private Long id;
    private Date created;
    private  Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
