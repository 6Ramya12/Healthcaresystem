package com.cg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcs.dto.User;
import com.cg.hcs.exception.NotFoundException;
import com.cg.hcs.repository.IAdminRepository;
import com.cg.hcs.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IAdminRepository adminRepository;
    @Autowired
    private IUserRepository userRepository;
    
    
    
    
    

    public IAdminRepository getAdminRepository() {
		return adminRepository;
	}

	public void setAdminRepository(IAdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public IUserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
    public User validateUser(String username, String password) {
    User user =	adminRepository.findByUsernameAndPassword(username, password);
    
    if(user==null)
    {
    	throw new  NotFoundException("Invalid Username or Password");
    }
    	
        return  user;
    }

    @Override
    public User addUser(User user) {
    	System.out.print("Add user--------");
    	System.out.print(user);
        adminRepository.save(user);
        return adminRepository.findByUsername(user.getUsername());
    }

    @Override
    public User removeUser(User user) {
    	
    	
    	User existingUser = adminRepository.findByUsername(user.getUsername());
    	
    	
    	if(existingUser!=null)
    	{
    		adminRepository.delete(existingUser);
    		
    		return existingUser;
    	}
    	else
    	{
    		throw new NotFoundException("No User with username "+user.getUsername());
    	}
    	
      
        
    }

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}
    
}