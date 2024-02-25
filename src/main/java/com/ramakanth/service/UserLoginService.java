package com.ramakanth.service;



import com.ramakanth.entity.UserLoginEntity;

public interface UserLoginService {
	
	public void saveUserLogin(UserLoginEntity userLoginEntity);
	
	public String findByUserLoginId(String userLoginId);

}
