package com.libretaDigital.services;

import com.libretaDigital.dao.UserDAO;
import com.libretaDigital.dao.UserDAOImpl;
import com.libretaDigital.model.User;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO = new UserDAOImpl();
	
	@Override
	public boolean buscarUsuario(User usuario) {
		// TODO Auto-generated method stub
		return userDAO.buscarUsuario(usuario);
	}

}
