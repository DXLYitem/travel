package com.example.travel.biz.impl;

import com.example.travel.biz.UserService;
import com.example.travel.dao.UserMapper;
import com.example.travel.entity.User;
import com.example.travel.util.Pages;
import com.example.travel.util.RedisUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisUtil redisUtil;

	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)//事物处理
	public int modifyUserById(User u) {
		User user=new User();
		user.setId(u.getId());
		user=userMapper.select(user).get(0);
		u.setBirthday(user.getBirthday());
		u.setUserCode(user.getUserCode());
		u.setUserPassword(user.getUserPassword());
		u.setCreatedBy(user.getCreatedBy());
		return userMapper.updateUserById(u);
	}

	public int addUser(User u) {
		return userMapper.insesrtUser(u);
	}

	//示例演示
	public List<User> list(User user) {
		//数据库查询用户集合
		List<User> li=userMapper.select(user);
		//移除user集合，防止user键已存在而添加错误
		redisUtil.remove("user");
		//判断键1是否存在
		boolean b1=redisUtil.exists("1");
		//设置键为1值为li集合的第一个用户
		redisUtil.set("1",li.get(0));
		//声明list集合
		List<Object> list=new ArrayList<>();
		//判断redis缓存里键为user集合是够存在
		boolean b2=redisUtil.exists("user");
		//把键为user值为li集合缓存到redis
		redisUtil.lPush("user",li);
		//判断是够存在user键，如果返回true则缓存成功
		boolean b3=redisUtil.exists("user");
		//把缓存的键为user的集合读取出来
		List<Object> userList=redisUtil.lRange("user",0,(list.size()));
		//判断键为1的缓存是否存在，若返回true则缓存成功
		boolean b=redisUtil.exists("1");
		//读取缓存键为1的值
		User u=(User)redisUtil.get("1");
		return li;
	}

	@Override
	public List<User> findItemByPage(int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		User u=new User();
		//查出全部用户
		List<User> list=userMapper.select(u);
		int count=userMapper.count(u.getUserName(), u.getUserRole());
		Pages<User> pages=new Pages<>();
		pages.setPageIndex(currentPage);
		pages.setPageSize(pageSize);
		pages.setTotalCount(count);
		pages.setList(list);
		return list;
	}
}
