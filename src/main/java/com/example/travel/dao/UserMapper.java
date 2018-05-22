package com.example.travel.dao;

import com.example.travel.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
	int count(
            @Param("userName") String name,
            @Param("userRole") Integer userRole);
	
	int updateUserById(User u);
	
	int insesrtUser(User u);


	List<User> select(User user);
	
	List<User> selectByPage(
            @Param("userName") String name,
            @Param("userRole") Integer userRole,
            @Param("from") Integer from,
            @Param("pageSize") Integer pageSize);
	int deleteUserById(@Param("ddd") Integer ddd);
	
	List<User> selectById(User user); 
}

	
