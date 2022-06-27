package com.supwisdom.tuition.biz.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.supwisdom.tuition.biz.entity.User;
import com.supwisdom.tuition.biz.mapper.UserMapper;
import com.supwisdom.tuition.biz.service.UserService;
import com.supwisdom.tuition.biz.validate.ValidateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

/**
 * @author hanlei
 * @date 2022/04/18
 */
@RestController
@RequestMapping("/at")
@AllArgsConstructor
@Api(tags = "设置")
public class TestController {
	private final UserService userService;
	private final UserMapper userMapper;


	@ApiOperation("用户集合list")
	@GetMapping("list")
	public List<User> search() {
		List<User> list = userService.getList();
		list.stream().forEach(System.out::println);
		return list;
	}

	@ApiOperation("查询数据")
	@GetMapping("list1")
	@ApiImplicitParams(value = {
		@ApiImplicitParam(name = "current", value = "当前页，默认为1", paramType = "query",  defaultValue = "1"),
		@ApiImplicitParam(name = "size", value = "每页记录数，默认为10", paramType = "query",  defaultValue = "10"),
		@ApiImplicitParam(name = "userName", value = "姓名",  paramType = "query")
	})
	public IPage<User> adddate(@ApiIgnore Page<User> page, @ApiIgnore User user) {
		Page<User> page1 = userService.page(new Page<>(page.getCurrent(), page.getSize()), Wrappers.lambdaQuery());
		return page1;

	}

	@ApiOperation("json")
	@PostMapping("json")
	public Boolean json(@RequestBody List<Long> param) {
		Optional.ofNullable(param).ifPresent(x -> {
			x.forEach(e -> {
				System.out.println(e);
			});
		});
		return true;
	}

	@ApiOperation("jsonUser")
	@PostMapping("jsonUser")
	public Boolean jsonUser(@Validated(ValidateGroup.InsertGroup.class) @RequestBody User param) {
		Optional.ofNullable(param).ifPresent(x -> {
			System.out.println(x);
		});
		return true;
	}

	@ApiOperation("print")
	@PostMapping("print")
	public void print() {
		System.out.println(new User());
	}
}
