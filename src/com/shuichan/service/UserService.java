package com.shuichan.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shuichan.pojo.User;

public interface UserService {
	
	int insertSelective(User user);
	
	int deleteUserByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(int id,String userName,HttpServletRequest request);
	
	int updateUserStatus(User user);
	
	int selectUserStatus(String userName);
	
	User selectByPrimaryKey(Integer id);
	
	User selectByUserNameAndPwd(Map<String, String> map);
	
	User selectByUserName(String userName);
	
	List<User> selectByPower(Integer power);
	
	List<User> selectUser();
}
