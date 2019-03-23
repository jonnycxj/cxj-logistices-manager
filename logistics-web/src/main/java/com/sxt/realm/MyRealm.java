package com.sxt.realm;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.security.auth.Subject;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.mapper.UserMapper;
import com.sxt.pojo.Role;
import com.sxt.pojo.User;
import com.sxt.service.IRoleService;
import com.sxt.service.IUserService;
@Component
public class MyRealm  extends AuthorizingRealm{
	@Resource
	private IUserService userService;
	@Resource 
	private IRoleService roleService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		try {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			User user=(User)principals.getPrimaryPrincipal();
			List<Role> list = roleService.selectRoleByUserId(user.getUserId());
			if(Objects.nonNull(list)&&list.size()>0) {
				for (Role role : list) {
					info.addRole(role.getRoleName());
				}
				return info;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		try {
			// 获取提交的账号
			UsernamePasswordToken t = (UsernamePasswordToken) token;
			// 获取登录的账号
			String userName = t.getUsername();
			User user = new User();
			user.setUserName(userName);
			List<User> list = userService.query(user);
			if(list == null || list.size() > 1||list.size()==0){
				// 账号不存在或者用户过多都返回null
				return null;
			}
			user = list.get(0);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),"cxj");
			return info;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
