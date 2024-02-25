package com.ramakanth.service;


import org.springframework.stereotype.Service;

import com.ramakanth.entity.UserLoginEntity;
import com.ramakanth.repository.UserLoginReopsitory;

@Service
public class UserLoginServiceImplementation implements UserLoginService {
	
	private UserLoginReopsitory userLoginRepo;
	
	public UserLoginServiceImplementation(UserLoginReopsitory userLoginRepo) {
		this.userLoginRepo=userLoginRepo;
	}
	public void saveUserLogin(UserLoginEntity userLoginEntity) {
		userLoginRepo.save(userLoginEntity);
	}
	public String findByUserLoginId(String userLoginId) {
		
		return userLoginRepo.findByUserLoginId(userLoginId);
		
	}
	}

