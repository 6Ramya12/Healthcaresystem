package com.cg.hcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.User;
import com.cg.hcs.repository.IAdminRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {

    @Autowired
    private IAdminRepository adminRepository;
    public static final String ADMIN = "ADMIN";
    /*@author :Pavani
	 * @return :Admin
	 * @description :This method register admin details to the repository and return the admin details
	 */

    @Override
    public User registerAdmin(String username,String password) {
    	User user = new User();
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setRole(ADMIN);
    	
        return adminRepository.save(user);    
    }
}
