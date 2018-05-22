package com.example.travel.biz;

import com.example.travel.entity.User;
import com.example.travel.util.Pages;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public interface UserService {
	
	/*int modifyUserById(User u);
	
	int addUser(User u);*/

	@Cacheable(key = "1")
	List<User> list(User user);
	
	/*Pages<User> listByPage(String userName, Integer userRole, Integer pageIndex, Integer pageSize);
	
	int remove(Integer id);
	
	List<User> getById(User user);*/

	public List<User> findItemByPage(int currentPage,int pageSize);
}
