package com.sxt.service;

import java.util.List;

import com.sxt.pojo.Role;

public interface IRoleService {
	/**
	 * 增加角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public boolean addRole(Role role) throws Exception ;
	/**
	 * 删除角色
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public boolean removeRole(Integer id) throws Exception;
	/**
	 * 更新角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public boolean updateRole(Role role) throws Exception ;
	/**
	 * 查询角色
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public List<Role> query(Role role) throws Exception;
	/**
	 * 通过user_id查询所有用户的所有角色信息
	 * @param userId
	 * @return
	 */
	public List<Role> selectRoleByUserId(Integer userId);
	

}
