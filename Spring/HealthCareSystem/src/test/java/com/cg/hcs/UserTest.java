package com.cg.hcs;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.hcs.dto.User;
import com.cg.hcs.repository.IUserRepository;
import com.cg.hcs.service.IUserService;
import com.cg.hcs.service.IUserServiceImpl;

@ExtendWith(SpringExtension.class)
class UserTest  {
	
	
	 @Mock
	 private IUserRepository iuserRepository;
	  @InjectMocks 
	  private IUserServiceImpl iuserService;
	
	private  List<User> userList ;
	private User user;
	@BeforeEach
	public void setUp()
	{
		
        User user1=new User(1,"anjali","anju","Admin");
        userList = new ArrayList<>();
        userList.add(new User(1,"anjali","anju","Admin"));
        userList.add(new User(2,"pavani","pavs","user"));
        userList.add(new User(3,"yaseena","yasee","user"));
	}
	@Test
	void testAddUser() {
		Mockito.when(iuserService.addUser(any())).thenReturn((User) userList);
		assertEquals(userList,iuserService.searchUser(user));
	}
	@AfterEach
	public void tearDown() {
		userList= Null;
		
	}
        /*user1.setId(1);
        user1.setPassword("anjali@609");
        user1.setRole("user");
   	    user1.setUsername("Anjali");
   	    
   	     User user2=new User();
         user2.setId(2);
         user2.setPassword("anjali@689");
         user2.setRole("admin");
	     user2.setUsername("Anju");
	     
	     userList.add(user1);
	     userList.add(user2);*/
	
	 
	

	
	@Test
	void findAllUsers() {
		
		
	
	     
	    when(iUserServiceImpl.getAllUser()).thenReturn(userList);
	       // List<User> usersList =iUserServiceImpl.getAllUser();
	        
	        //System.out.println(usersList);
	        assertEquals(userList,iUserServiceImpl.getAllUser());
}
	
	
	
	
	@AfterEach
	
	public void tearDown()
	{
		userList = null;
	}
	/*

	@Test
	void testRemoveUser() {
	
	User user1=new User();
	user1.setId(1);
	user1.setPassword("Anjali@609");
	user1.setRole("user");
	user1.setUsername("Anjali");
	
	Optional<User> optionalUser = Optional.of(user1);
	when(iUserRepository.findById(1)).thenReturn(optionalUser);
	User user = optionalUser.get(); 
    //doNothing().when(iUserRepository).deleteById(1);
	User rUser = iUserServiceImpl.removeUser(user1);
	assertEquals(user,rUser);
	}
                  

	
	
	@Test
	 void addUser() { User user = new User(); user.setId(1);
	 user.setPassword("anjali@609"); user.setRole("user");
	 user.setUsername("Anjali");
	 when(iUserRepository.save(user)).thenReturn(user); User newUser =
	 iUserServiceImpl.addUser(user); assertEquals(user,newUser); }
*/	 
}


