package com.cg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.dto.User;
@Repository
public interface IUserRepository  extends JpaRepository<User,Integer>{
	
	public User findByusername(String userName);
	



}
