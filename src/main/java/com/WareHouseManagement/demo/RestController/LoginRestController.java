package com.WareHouseManagement.demo.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.Login;
import com.WareHouseManagement.demo.Service.LoginService;

@RestController
@RequestMapping("login")
public class LoginRestController {

	@Autowired
	LoginService loginService;
	//this method is for validating login credentials db operations handled in service 
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public String insert(@RequestBody Login log) {
		   String status=loginService.check(log);
			return status;
		   
		   
	   }

}
