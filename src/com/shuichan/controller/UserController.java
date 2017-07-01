package com.shuichan.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shuichan.pojo.User;
import com.shuichan.service.UserService;

@Controller
public class UserController {
	
	@Resource
	public UserService userService;
	
	private static Logger log = Logger.getLogger(UserController.class.getName());

	@RequestMapping("/index")
	public String intoRegister(HttpServletRequest request, Model model){
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request, Model model){
		User user = new User();
		String userName = request.getParameter("userName");
		log.info("userName === " + userName);
		User isExistUser = this.userService.selectByUserName(userName);
		String isExist;
		if(isExistUser!=null){
			if(userName.equals(isExistUser.getUserName())){
				isExist = "用户已存在";
			}else{
				isExist = null;
			}
			model.addAttribute("isExist", isExist);
			return "index";
		}else{
			user.setUserName(userName);
			user.setPassword(request.getParameter("password"));
			user.setPower(Integer.valueOf(request.getParameter("power")));
			int result = this.userService.insertSelective(user);
			log.info("register result:" + result);
			return "index";
		}	
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model){
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		log.info("userName === " + userName);
		log.info("password === " + password);
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName",userName);
		map.put("password", password);
		User isExistUser = this.userService.selectByUserNameAndPwd(map);
		String isExist;
		if(isExistUser==null){	
			isExist = "用户不存在";
			model.addAttribute("isExist", isExist);
			return "index";
		}else{
			isExistUser.setStatus(1);
			this.userService.updateUserStatus(isExistUser);
			HttpSession session = request.getSession();
			session.setAttribute("user",isExistUser);
			return "shouye";
		}	
	}
}
