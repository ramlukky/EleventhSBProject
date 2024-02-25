package com.ramakanth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	@Autowired
	public JavaMailSender javaMailSender;

	public Boolean sendEmail(UserEntity userEntity){

	SimpleMailMessage smm=new SimpleMailMessage();

	smm.setFrom("a.ramakanth.recruiter@gmail.com");
	smm.setTo(userEntity.getUserEmail());
	String body="Hi "+userEntity.getUserName()+", you have succesfully Registered: Thank you";
	smm.setText(body);
	smm.setSubject("Registration Sucessful");

javaMailSender.send(smm);

System.out.println("mail sent;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");

return true;
	}

public String findByUserEmail(String userEmail){
return userRepo.findByUserEmail(userEmail);
	}
	}
	
	

