package com.WareHouseManagement.demo.RestController;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.CustomerInfo;
import com.WareHouseManagement.demo.Service.CustomerInfoService;

@RestController
@RequestMapping("customer")
public class CustomerDetailsRestController {
	
	@Autowired
	CustomerInfoService customerService;
	
	//this method is for checking the customer exists or not db operations handled in service
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public String findCustomer(@RequestBody String cust) {  
		CustomerInfo custObj=customerService.check(cust);
		   String status;
		   if (custObj.getAdderss()!=null)
			   status="Yes";
		   else
			   status="No";
			return status; 
	   }
	
	//this method is for adding new customer db operations handled in service
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String createCustomer(@RequestBody CustomerInfo cust) {
		   String status=customerService.createCustomer(cust);
			return status; 
	   }
	
	//this method is for getting customer details db operations handled in service
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	   public CustomerInfo displayCustomer(@RequestBody String cust) {
		   CustomerInfo status=customerService.displayCustomer(cust);
			return status; 
	   }
	
	

}
