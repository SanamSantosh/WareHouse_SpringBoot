package com.WareHouseManagement.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.MerchantDetails;
import com.WareHouseManagement.demo.Service.MerchantLoginService;

@RestController
@RequestMapping("merchantlogin")
public class MerchantLoginRestController {
	
	@Autowired
	MerchantLoginService merchantService;
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public String insert(@RequestBody MerchantDetails merchant) {
		   String status=merchantService.check(merchant);
			return status;
		   
		   
	   }

}
