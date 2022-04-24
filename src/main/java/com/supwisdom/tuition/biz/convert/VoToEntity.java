package com.supwisdom.tuition.biz.convert;

import com.supwisdom.tuition.biz.entity.User;
import com.supwisdom.tuition.biz.vo.UserVo;
import org.mapstruct.Mapper;

/**
 * @author hanlei
 * @date 2022/04/19
 */
@Mapper(componentModel = "spring")
public interface VoToEntity {
	/**
	 * 转为entity对象
	 *
	 * @param user entity对象
	 * @return com.supwisdom.tuition.biz.entity.User
	 */
	User convert(UserVo user);
}