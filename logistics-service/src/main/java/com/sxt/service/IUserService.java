package com.sxt.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sxt.dto.UserDto;
import com.sxt.pojo.User;

public interface IUserService {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public  boolean addUser(User user) throws Exception; 
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean removeUser(Integer id ) throws Exception;
	
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean updateUser(User user) throws Exception; 
	/**
	 * 查询所有用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public  List<User> query(User user) throws Exception;
	
	/**
	 * 保存增加和修改用户信息
	 * @param userDto 包含了user和roles信息
	 * @return 
	 * @throws Exception
	 */
	public boolean saveUserAddOrUpdate (UserDto userDto,Model model) throws Exception;
	/**
	 * 增加或者修改用户
	 * @param id
	 * @return
	 */
	public String addOrUpdate(Integer id,Model model) throws Exception;
}
