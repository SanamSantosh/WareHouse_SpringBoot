package com.WareHouseManagement.demo.Service;

import java.util.Optional;

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

	// this method is for validating merchant login credentials
	public String check(MerchantDetails log) {
		String status;
		Optional<MerchantDetails> merchantObj = merchantrepo.findById(log.getMerchant_id());
		if (merchantObj.isPresent() && log.getMerchant_id() == merchantObj.get().getMerchant_id()
				&& log.getPassword().equals(merchantObj.get().getPassword())) {

			status = "Yes";
		} else {
			status = "No";
		}
		return status;
	}

}
