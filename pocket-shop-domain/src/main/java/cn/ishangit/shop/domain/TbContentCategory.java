package cn.ishangit.shop.domain;

import cn.ishangit.shop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Chen
 * @create 2019-05-20 14:20
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    @NotNull(message = "分类名称不能为空")
    private String name;
    private  Integer status;
    private Integer sortOrder;
    @JsonProperty("isParent")
    private Boolean isParent;

}
