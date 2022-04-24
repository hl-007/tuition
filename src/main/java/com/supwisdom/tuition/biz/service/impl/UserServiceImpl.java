package com.supwisdom.tuition.biz.service.impl;

import com.supwisdom.tuition.biz.entity.User;
import com.supwisdom.tuition.biz.mapper.UserMapper;
import com.supwisdom.tuition.biz.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanlei
 * @since 2022-03-31
 */
@Service
@AllArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
	private final UserMapper userMapper;

	@Override
	public List<User> getList() {
		return userMapper.getList();
	}
}
