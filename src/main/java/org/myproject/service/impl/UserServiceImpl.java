package org.myproject.service.impl;

import javax.annotation.Resource;

import org.myproject.dao.GetUserDao;
import org.myproject.entity.User;
import org.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private GetUserDao getUserDao;
	
	
	public User getUserOne(int userId) {
		
		return this.getUserDao.getUser(userId);
	}

	

}
