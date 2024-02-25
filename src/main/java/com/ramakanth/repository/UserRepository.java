package com.ramakanth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ramakanth.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
@Query("SELECT userEmail FROM UserEntity WHERE userEmail = :userEmail")
public String findByUserEmail(@Param("userEmail") String userEmail);
}
