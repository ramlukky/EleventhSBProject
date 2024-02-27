package com.ramakanth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramakanth.entity.UserEntity;
import com.ramakanth.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepo;

	public Boolean save(UserEntity userEntity){
	userRepo.save(userEntity);

	return (userEntity.getUserId()==null);
	}

	
	

public String findByUserEmail(String userEmail){
return userRepo.findByUserEmail(userEmail);
	}
	}
	
	

