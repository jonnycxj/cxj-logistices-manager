package com.sxt.dto;

import java.util.List;

import com.sxt.pojo.User;

public class UserDto {
	
	private User user;
	
	private List<Integer> roles;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getRoles() {
		return roles;
	}

	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDto [user=" + user + ", roles=" + roles + "]";
	}
	
	

}
