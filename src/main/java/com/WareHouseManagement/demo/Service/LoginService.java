package com.WareHouseManagement.demo.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.Login;
import com.WareHouseManagement.demo.Repository.LoginRepository;

@Service
@Component
@EnableAutoConfiguration
public class LoginService {
	@Autowired
	LoginRepository loginrepo;
	
	//this method is for validating login credentials
	public String check(Login log) {
		String status = null;
		ArrayList<Login> loginObj=(ArrayList<Login>) loginrepo.findAll();
		for (int i = 0; i < loginObj.size(); i++) {
			if(log.getLogin_id().equals(loginObj.get(i).getLogin_id()) && log.getPassword().equals(loginObj.get(i).getPassword())) {
				
				status="Yes";
				break;
			}
			else {
				status="No";
			}
		}
		return status;
	}

}
