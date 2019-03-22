package com.sxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.pojo.Role;
import com.sxt.service.IRoleService;

@Controller

public class RoleController {
	@Resource
	private IRoleService service;
	
	/**
	 * 对静态路径的返回
	 * @param path
	 * @return
	 */
	@RequestMapping("/{path}")
	public String show(@PathVariable String path) {
		return path;
	}
	@RequestMapping("/role/query")
	public String query(Role role , Model model) throws Exception {
		List<Role> list = service.query(role);
		model.addAttribute("list", list);
		return "role/role";
	}
}
