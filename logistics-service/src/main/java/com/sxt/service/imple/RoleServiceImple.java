package com.sxt.service.imple;

import java.awt.peer.RobotPeer;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sxt.mapper.RoleMapper;
import com.sxt.pojo.Role;
import com.sxt.pojo.RoleExample;
import com.sxt.pojo.RoleExample.Criteria;
import com.sxt.service.IRoleService;
@Service
public class RoleServiceImple  implements IRoleService {
	@Resource
	private RoleMapper dao;
	
	@Override
	public boolean addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertSelective(role)>0;
	}

	@Override
	public boolean removeRole(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id)>0;
	}

	@Override
	public boolean updateRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(role)>0;
	}

	@Override
	public List<Role> query(Role role) throws Exception {
		
		RoleExample example = new RoleExample();
		Criteria criteria = example.createCriteria();
		if(role!=null) {
			if(role.getRoleName()!=null&&!"".equals(role.getRoleName())) {
				criteria.andRoleNameLike("%"+role.getRoleName()+"%");
			}
		}
		return dao.selectByExample(example);
	}

}
