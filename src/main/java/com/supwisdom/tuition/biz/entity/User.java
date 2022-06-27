package com.supwisdom.tuition.biz.entity;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author hanlei
 * @since 2022-03-31
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@TableName("a_user")
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("hl.xx")
@ApiModel(value = "User对象", description = "你好，明天")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    @TableId("uid")
    @Value("111")
    private Long uid;

    @ApiModelProperty("姓名")
    @TableField("user_name")
    @Value("${xxx.xx}")
    private String userName;

    @ApiModelProperty("年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("电话号码")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
