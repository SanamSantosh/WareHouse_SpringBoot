package com.WareHouseManagement.demo.Service;

import java.util.Optional;

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

	// this method is for validating login credentials
	public String check(Login log) {
		String status = null;
		Optional<Login> loginObj = loginrepo.findById(log.getLogin_id());
		if (loginObj.isPresent() && log.getLogin_id().equals(loginObj.get().getLogin_id())
				&& log.getPassword().equals(loginObj.get().getPassword())) {

			status = "Yes";
		} else
			status = "No";
		return status;
	}

}
