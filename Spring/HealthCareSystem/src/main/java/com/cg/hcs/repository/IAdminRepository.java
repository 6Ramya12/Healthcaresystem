package com.cg.hcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);
	User deleteByUsername(String username);
}
