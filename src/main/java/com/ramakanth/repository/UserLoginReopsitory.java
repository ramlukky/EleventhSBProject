package com.ramakanth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ramakanth.entity.UserLoginEntity;



public interface UserLoginReopsitory extends JpaRepository<UserLoginEntity, Integer> {
	@Query("SELECT userLoginPassword FROM UserLoginEntity WHERE userLoginId = :userLoginId")
	public String findByUserLoginId(@Param("userLoginId") String userLoginId);
	


}
