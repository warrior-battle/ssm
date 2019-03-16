package org.myproject.web;

import org.myproject.entity.User;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping // 第一级路径为空
public class Test {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {		
		User user=userService.getUserOne(1);
		System.out.println("hello");
		System.out.println(user.getUserName());
		model.addAttribute("commandList", "hello");
		model.addAttribute("page","good");
		return "index";
	}
}
