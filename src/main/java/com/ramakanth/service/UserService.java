package com.ramakanth.service;

import com.ramakanth.entity.UserEntity;

public interface UserService {

	
	
	public Boolean save(UserEntity userEntity);
	
	public String findByUserEmail(String userEmail);
	

}
