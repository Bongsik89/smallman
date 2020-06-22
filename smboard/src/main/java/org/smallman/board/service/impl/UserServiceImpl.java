package org.smallman.board.service.impl;

import org.smallman.board.dao.UserDAO;
import org.smallman.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO; 

}
