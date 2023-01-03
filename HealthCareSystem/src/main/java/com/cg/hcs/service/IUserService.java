package com.cg.hcs.service;

import java.util.List;

import com.cg.hcs.dto.User;

public interface IUserService {
   public User validateUser(String username, String password);

   public User addUser(User user);

    public User removeUser(User user);
    
    public List<User> getAllUser();
}