package com.WareHouseManagement.demo.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.MerchantDetails;
import com.WareHouseManagement.demo.Repository.MerchantLoginRepository;

@Service
@Component
@EnableAutoConfiguration
public class MerchantLoginService {
	
	@Autowired
	MerchantLoginRepository merchantrepo;
	
	//this method is for validating merchant login credentials
	public String check(MerchantDetails log) {
		String status = null;
		ArrayList<MerchantDetails> loginObj=(ArrayList<MerchantDetails>) merchantrepo.findAll();
		for (int i = 0; i < loginObj.size(); i++) {
			if(log.getMerchant_id()==loginObj.get(i).getMerchant_id() && log.getPassword().equals(loginObj.get(i).getPassword())) {
				
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
