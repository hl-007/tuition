package com.supwisdom.tuition.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.supwisdom.tuition.biz.entity.User;
import com.supwisdom.tuition.biz.service.UserService;
import com.supwisdom.tuition.biz.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hanlei
 * @date 2022/06/25
 */
@RestController
@RequestMapping("/my")
@AllArgsConstructor
@Api(tags = "MyBatisPlus测试语句")
public class MyBatisController {
	private UserService userService;

	@ApiOperation("模糊查询")
	@GetMapping("like")
	public List<User> like(UserVo userVo) {
		Page<User> page = userService.page(new Page<>(1, 2), Wrappers.<User>lambdaQuery().like(User::getUserName, userVo.getUserName()));
		return page.getRecords();
	}

	@ApiOperation("根据多个id查询")
	@GetMapping("searchByIds/{ids}")
	public List<User> searchByIds(@PathVariable("ids") List<String> ids) {
		return Lists.newArrayList();
	}

}
