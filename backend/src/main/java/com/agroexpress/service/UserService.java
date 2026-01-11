package com.agroexpress.service;

import com.agroexpress.exception.UserException;
import com.agroexpress.model.User;

public interface UserService {
	public User findUserProfileByJwt(String jwt) throws UserException;
	public User findUserByEmail(String email) throws UserException;


}


