package cn.ishangit.shop.domain;

import cn.ishangit.shop.commons.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author Chen
 * @create 2019-05-21 12:19
 */
@Data
public class TbContent extends BaseEntity {
    @Length(min = 1, max = 20, message = "标题长度1-20之间")
    private String title;
    @NotNull(message = "子标题不能为空")
    private String subTitle;
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    @NotNull(message = "内容不能为空")
    private String content;

    private TbContentCategory tbContentCategory;
}
