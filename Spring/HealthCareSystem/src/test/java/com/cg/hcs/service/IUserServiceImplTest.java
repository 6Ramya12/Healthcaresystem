package com.cg.hcs.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.hcs.dto.User;
import com.cg.hcs.repository.IAdminRepository;
import com.cg.hcs.repository.IUserRepository;
@ExtendWith(SpringExtension.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = IUserServiceImpl.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class IUserServiceImplTest {

	//@Autowired
	 @Mock
	 private IUserRepository iuserRepository;
	@Mock
	private IAdminRepository iadminRepo;
	  @InjectMocks 
	  private IUserServiceImpl iuserService;
	
	private  List<User> userList ;
	private User user;
	@BeforeEach
	public void setUp()
	{
		
        
        userList = new ArrayList<>();
        userList.add(new User(1,"anjali","anju","Admin"));
        userList.add(new User(2,"pavani","pavs","user"));
        userList.add(new User(3,"yaseena","yasee","user"));
	}
	
	
	
	@Test
	
	
	public void testAllUsers()
	{
		
		when(iuserService.getAllUser()).thenReturn(userList);
		
		assertEquals(userList, iuserService.getAllUser());
	}
	
	
	
	
	
	@AfterEach
	public void tearDown() {
		userList= null;
		
	}

}
