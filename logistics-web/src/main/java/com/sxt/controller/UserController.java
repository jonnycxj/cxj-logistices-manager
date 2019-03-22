package com.sxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.dto.UserDto;
import com.sxt.pojo.User;
import com.sxt.service.IUserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Resource
	private IUserService service;
	/**
	 * 根据username查询用户列表的所有信息
	 * @param user 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/query")
	public String query(User user ,Model model ) throws Exception{
		List<User> list = service.query(user);
		model.addAttribute("list", list);
		return "user/user";
	}
	
	/**
	 * 增加或者删除
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addOrUpdate")
	public String addOrUpdate(Integer id,Model model ) throws Exception{
		return service.addOrUpdate(id,model);
	}
	/**
	 * 保存用户信息
	 * @param userDto
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/saveUserAddOrUpdate")
	public String saveUserAddOrUpdate(UserDto userDto,Model model)throws Exception{
		
		boolean b = service.saveUserAddOrUpdate(userDto, model);
		return "redirect:/user/query";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) throws Exception {
		service.removeUser(id);
		
		
		return "redirect:/user/query";
	}
	
}
