package com.supwisdom.tuition.biz.mapper;

import com.supwisdom.tuition.biz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanlei
 * @since 2022-03-31
 */
public interface UserMapper extends BaseMapper<User> {

	/**
	 * 获取所有用户信息
	 *
	 * @return java.util.List<com.supwisdom.tuition.biz.entity.User>
	 */
	List<User> getList();

}
