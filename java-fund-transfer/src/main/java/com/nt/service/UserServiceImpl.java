package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private LoginDAO dao;

	@Override
	public UserDTO checkLogin(String userName, String userPassword) {
		UserBO ubo = dao.validate(userName, userPassword);
		UserDTO udto = new UserDTO();
		if (ubo != null)
			BeanUtils.copyProperties(ubo, udto);
		else {
			return udto;
		}
		return udto;
	}
}// class
