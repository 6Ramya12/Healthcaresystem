package com.cg.hcs.controller;

import com.cg.hcs.dto.User;
import com.cg.hcs.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")//
public class IAdminController {

	@Autowired
	private IAdminService adminService;

	@PostMapping(value = "/register")
	public User registerAdmin(@RequestParam String username,@RequestParam String password) {
		 return adminService.registerAdmin(username,password);
	}
}
