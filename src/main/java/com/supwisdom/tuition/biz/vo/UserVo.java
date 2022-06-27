package com.supwisdom.tuition.biz.vo;

import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.supwisdom.tuition.biz.validate.MobilePattern;
import com.supwisdom.tuition.biz.validate.ValidateGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author hanlei
 * @date 2022/04/19
 */
@Data
public class UserVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "发布类型 0:全部、1招领、2:失物")
	@Null(groups = {ValidateGroup.InsertGroup.class}, message = "添加时uid必须为空")
	@NotNull(groups = {ValidateGroup.UpdateGroup.class}, message = "修改时uid不能为空")
	@Range(min = 0, max = 2, groups = ValidateGroup.UpdateGroup.class, message = "超出范围了")
	private Long uid;

	@ApiModelProperty(value = "姓名(添加，传 | 修改，不传)")
	@NotBlank(groups = ValidateGroup.InsertGroup.class, message = "添加名字不能为空")
	private String userName;

	@ApiModelProperty("年龄")
	@NotNull
	private Integer age;

	@ApiModelProperty(value = "邮箱")
	@Email(groups = {ValidateGroup.InsertGroup.class, ValidateGroup.UpdateGroup.class}, message = "邮箱格式不对")
	@NotBlank(groups = {ValidateGroup.InsertGroup.class, ValidateGroup.UpdateGroup.class}, message = "添加或修改邮箱不能为空")
	private String email;

	@ApiModelProperty("电话号码")
	@MobilePattern(groups = {ValidateGroup.InsertGroup.class, ValidateGroup.UpdateGroup.class},
		regexp = "^1\\d{10}$", message = "请输入合理的手机电话,校验规则：^1\\d{10}$")
	@TableField("telephone")
	private String telephone;

	@ApiModelProperty("创建时间")
	@DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	@JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
	private LocalDateTime createTime;
}