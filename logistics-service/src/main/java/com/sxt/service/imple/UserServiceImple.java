package com.sxt.service.imple;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sxt.dto.UserDto;
import com.sxt.mapper.UserMapper;
import com.sxt.pojo.Role;
import com.sxt.pojo.User;
import com.sxt.pojo.UserExample;
import com.sxt.pojo.UserExample.Criteria;
import com.sxt.service.IRoleService;
import com.sxt.service.IUserService;
@Service
public class UserServiceImple implements IUserService {

	@Resource
	private UserMapper userDAO;
	@Resource
	private IRoleService roleServiceImple;
	
	@Override
	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.insertSelective(user)>0;
	}

	@Override
	public boolean removeUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		//删除用户的所有角色
		userDAO.delectRoleByUserId(id);
		
		return userDAO.deleteByPrimaryKey(id)>0;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.updateByPrimaryKeySelective(user)>0;
	}

	@Override
	public List<User> query(User user) throws Exception {
		UserExample example=new UserExample();
		Criteria criteria = example.createCriteria();
		if(user.getRealName()!=null&&!user.getRealName().equals("")) {
			criteria.andUserNameLike("%"+user.getRealName()+"%");
		}
		return userDAO.selectByExample(example);
	}

	@Override
	public boolean saveUserAddOrUpdate(UserDto userDto ,Model model) throws Exception {
		// TODO Auto-generated method stub
		User user = userDto.getUser();
		List<Integer> roles = userDto.getRoles();
		
			if(user.getUserId()!=null&&user.getUserId()>0) {
				//修改的内容模式
				//1、保存用户信息
				userDAO.updateByPrimaryKeySelective(user);
				//2、删除用户原先的所有角色
				userDAO.delectRoleByUserId(user.getUserId());
				
				
			}else {
				//增加模式
				userDAO.insert(user);
			}
			for (Integer roleId : roles) {
				userDAO.addUserIdAndRoleId(user.getUserId(), roleId);
			}
		return false;
	}

	@Override
	public String addOrUpdate(Integer id,Model model) throws Exception {
		// TODO Auto-generated method stub
		if(id!=null&&id!=0) {
		//修改用户模式
			//1、修改查询用户的所有信息
			User user = userDAO.selectByPrimaryKey(id);
			//2、查询用户的所有角色
			List<Integer> roleids = userDAO.selectRoleIdByUserId(id);
			//3、绑定数据给视图层
			model.addAttribute("user", user);
			model.addAttribute("roleids", roleids);
		}
		
		//增加用户模式
		//查询所有role列表
		//添加modele
		//跳转页面
		List<Role> roles = roleServiceImple.query(null);
		model.addAttribute("roles", roles);
		
		return "user/addOrUpdate";
	}
}
