package com.itheima.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Reference
	private UserService userService;
	
	@RequestMapping("/showName")
	//表示返回值是一个输出
	@ResponseBody
	public String showName(){
		return userService.getName();
	}
}
