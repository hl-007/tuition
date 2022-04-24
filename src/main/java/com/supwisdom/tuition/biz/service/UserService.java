package com.supwisdom.tuition.biz.service;

import com.supwisdom.tuition.biz.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanlei
 * @since 2022-03-31
 */
public interface UserService extends IService<User> {

	/**
	 * 获取用户信息
	 *
	 * @param
	 * @return java.util.List<com.supwisdom.tuition.biz.entity.User>
	 */
	List<User> getList();

}
