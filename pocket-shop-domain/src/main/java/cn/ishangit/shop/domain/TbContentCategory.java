package cn.ishangit.shop.domain;

import cn.ishangit.shop.commons.persistence.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Chen
 * @create 2019-05-20 14:20
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    @Length(min = 1,max = 20,message = "分类名称请输入1-20个字之间")
    private String name;
    private  Integer status;
    @NotNull(message = "排序不能为空")
    private Integer sortOrder;
    @JsonProperty("isParent")
    private Boolean isParent;

    private TbContentCategory parent;

}
