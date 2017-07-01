package com.shuichan.dao;

import java.util.List;
import java.util.Map;

import com.shuichan.pojo.User;

public interface UserDao {
	
	int insert(User user);
	
	int insertSelective(User user);
	
	int deleteByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(User user);
    
    int updateByPrimaryKeySelective(User user);
    
    int updateUserStatus(User user);
    
    User selectByPrimaryKey(Integer id);
    
    User selectByUserName(String userName);

    User selectByUserNameAndPwd(Map<String, String> map);
    //可以用于选择专家列表
    List<User> selectByPower(Integer power);
    //查询所有用户
    List<User> selectUser();
}
