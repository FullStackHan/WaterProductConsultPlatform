package com.shuichan.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.shuichan.dao.UserDao;
import com.shuichan.pojo.User;
import com.shuichan.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	public StringBuffer printUser(User user){
		StringBuffer strBuf= new StringBuffer();
		strBuf.append("id = "+user.getId());
		strBuf.append(",userName = "+user.getUserName());
		strBuf.append(",password = "+user.getPassword());
		strBuf.append(",power = "+user.getPower());
		return strBuf;
	}
	
	@Override
	public User selectByPrimaryKey(Integer id) {
		User user = this.userDao.selectByPrimaryKey(id);
		if(user!=null){
			System.out.println("selectByPrimaryKey result:" + this.printUser(user));
			return user;
		}else{
			return null;
		}
	}

	@Override
	public User selectByUserNameAndPwd(Map<String, String> map) {
		User user = this.userDao.selectByUserNameAndPwd(map);
		if(user!=null){
			System.out.println("selectByUserNameAndPwd result:" + this.printUser(user));
			return user;	
		}else{
			return null;
		}
	}

	@Override
	public User selectByUserName(String userName) {
		User user = this.userDao.selectByUserName(userName);
		if(user!=null){
			System.out.println("selectByUserName result:" + this.printUser(user));
			return user;	
		}else{
			return null;
		}
	}

	@Override
	public List<User> selectByPower(Integer power) {
		List<User> list = this.userDao.selectByPower(power);
		System.out.println("selectByPower list:" + list.size());
		return list;
	}

	@Override
	public List<User> selectUser() {
		List<User> list = this.userDao.selectUser();
		System.out.println("selectByPower list:" + list.size());
		return list;
	}

	@Override
	public int insertSelective(User user) {
		if(this.selectByUserName(user.getUserName())!=null){
			return -1;
		}else{
			System.out.println("userName:" + user.getUserName());
			System.out.println("password:" + user.getPassword());
			System.out.println("power:" + user.getPower());
			int result = userDao.insertSelective(user);
			System.out.println("Insert result:" + result);
			return result;
		}
	}

	@Override
	public int deleteUserByPrimaryKey(Integer id) {
		if(this.selectByPrimaryKey(id)!=null){
			int result = this.userDao.deleteByPrimaryKey(id);
			System.out.println("Delete result:" + result);
			return id;
		}else{
			return -1;
		}

	}

	@Override
	public int updateByPrimaryKeySelective(int id, String userName,
			HttpServletRequest request) {
		if(this.selectByPrimaryKey(id)!=null){
			User user = new User();
			user.setId(id);
			user.setUserName(userName);
			user.setPower(Integer.valueOf(request.getParameter("power")));
			user.setPersonName(request.getParameter("personName"));
			
			int result = this.userDao.updateByPrimaryKeySelective(user);
			System.out.println("update result:" + result);
			return result;
		}else{
			return -1;
		}
	}

	@Override
	public int updateUserStatus(User user) {
		if(this.selectByPrimaryKey(user.getId()) != null){
			int result = this.userDao.updateUserStatus(user);
			return result;
		}else{
			return -1;
		}
		
	}

	@Override
	public int selectUserStatus(String userName) {
		User user = this.userDao.selectByUserName(userName);
		if(user != null){
			return user.getStatus();
		}else{
			return -1;
		}
	}
}
