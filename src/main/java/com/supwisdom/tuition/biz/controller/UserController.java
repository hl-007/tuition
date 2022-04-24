package com.supwisdom.tuition.biz.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.supwisdom.tuition.biz.convert.VoToEntity;
import com.supwisdom.tuition.biz.entity.User;
import com.supwisdom.tuition.biz.mapper.UserMapper;
import com.supwisdom.tuition.biz.service.UserService;
import com.supwisdom.tuition.biz.validate.ValidateGroup;
import com.supwisdom.tuition.biz.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hanlei
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/t")
@AllArgsConstructor
@Api(tags = "测试")
public class UserController {
	private final VoToEntity voToEntity;
	private final UserService userService;
	private final UserMapper userMapper;


	@ApiOperation("用户集合list")
	@GetMapping("list")
	public List<User> search() {
		List<User> list = userService.getList();
		list.stream().forEach(System.out::println);
		return list;
	}

	@ApiOperation("用户集合map")
	@GetMapping("list1")
	public Map<String, User> searchMap() {
		List<User> list = userService.getList();
		list.stream().forEach(System.out::println);
		LinkedHashMap<String, User> map = Maps.newLinkedHashMap();
		list.stream().forEach(x -> {
			map.put("@" + x.getUid().toString(), x);
		});
		return map;
	}

	@ApiOperation("获取用户")
	@GetMapping("user")
	public User searchMap1() throws Exception {
		List<User> list = userService.getList();
		return list.stream().findFirst().orElseThrow(Exception::new);
	}

	@ApiOperation("获取集合set")
	@GetMapping("set")
	public Set<User> set()  {
		Set<User> set = new LinkedHashSet<>();
		userService.getList().stream().forEach(x -> {
			set.add(x);
		});
		return set;
	}

	@ApiOperation("用户数组")
	@GetMapping("array")
	public User[] arr()  {
		List<User> list = userService.getList();
		User[] users = list.toArray(new User[list.size()]);
		return users;
	}

	@ApiOperation("测试1")
	@GetMapping("a")
	public List<String> a() {
		return Lists.newArrayList("xiaoming", "tongtong", "fsa afas").stream().collect(Collectors.toList());
	}

	@ApiOperation("测试2")
	@GetMapping("aa")
	public List<String> aa() {
		return Lists.newArrayList("xiaoming", "tongtong", "1234").stream().collect(Collectors.toList());
	}

	@ApiOperation("添加用户")
	@PostMapping("add")
	public boolean add(UserVo user) {
		return userService.save(voToEntity.convert(user));
	}

	@ApiOperation("验证添加用户")
	@PostMapping("/addUser")
	public boolean addUser(@Validated(ValidateGroup.InsertGroup.class) UserVo user) {
		User convert = voToEntity.convert(user);
		return userService.save(convert);
	}

	@ApiOperation("验证修改用户")
	@PostMapping("/updateUser")
	public boolean updateUser(@Validated(ValidateGroup.UpdateGroup.class)  UserVo user) {
		User convert = voToEntity.convert(user);
		return userService.update(convert, null);
	}

	@ApiOperation(value = "验证查询用户")
	@GetMapping("searchUser")
	@ApiImplicitParams(value = {
		@ApiImplicitParam(name = "current", value = "当前页", paramType = "query", defaultValue = "1"),
		@ApiImplicitParam(name = "size", value = "每页记录数", paramType = "query",  defaultValue = "10"),
		@ApiImplicitParam(name = "userName", value = "姓名",  paramType = "query")
	})
	public boolean searchUser(@ApiIgnore Page<User> page, @Validated UserVo user) {
		return true;
	}


	@ApiOperation("批量添加")
	@PostMapping("addp")
	public boolean addp(UserVo user) {
		List<User> list = new ArrayList<>();
		userService.save(voToEntity.convert(user));
		int num = 10;
		Lists.newArrayList(user).stream().forEach(x -> {
			for (int i = 0; i < num; i++) {
				list.add(new User(x.getUid() + i, x.getUserName() + i,
					x.getAge() + i, i + x.getEmail(), LocalDateTime.now()));
			}
		});

		boolean b = userService.saveOrUpdateBatch(list);
		return b;
	}

	@ApiOperation("获取id")
	@PostMapping("id")
	public void s(User u) {
		int insert = userMapper.insert(u);
		Long uid = u.getUid();
		System.out.println(insert);
	}
}
