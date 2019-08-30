package com.WareHouseManagement.demo.Service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.CustomerInfo;
import com.WareHouseManagement.demo.Repository.CustomerDetailsRepository;

@Service
@Component
@EnableAutoConfiguration
public class CustomerInfoService {
	
	@Autowired
	CustomerDetailsRepository customerRepo;
	
	//this method is for checking the customer exists or not
	public CustomerInfo check(String cust) {
		ArrayList<CustomerInfo> customerObj=(ArrayList<CustomerInfo>) customerRepo.findAll();
		CustomerInfo custObj=new CustomerInfo();
		int cust_id=Integer.parseInt(cust);
		for (int i = 0; i < customerObj.size(); i++) {
			if(cust_id==customerObj.get(i).getCustomer_id()) {
				custObj.setCustomer_id(customerObj.get(i).getCustomer_id());
				custObj.setAdderss(customerObj.get(i).getAdderss());
				custObj.setName(customerObj.get(i).getName());
				custObj.setPhonenumber(customerObj.get(i).getPhonenumber());
			}
		}
		return custObj;
	}
	
	//this method is for adding new customer
	public String createCustomer(CustomerInfo cust) {
		customerRepo.save(cust);
		   String status;
		   if (cust.getAdderss()!=null)
			   status="Customer Created with id: "+cust.getCustomer_id();
		   else
			   status="Couldnt create the customer";
			return status; 
	}
	
	//this method is for getting customer details
	public CustomerInfo displayCustomer(String custid) {
		int cust_id=Integer.parseInt(custid);
		ArrayList<CustomerInfo> customerObj=(ArrayList<CustomerInfo>) customerRepo.findAll();
		CustomerInfo custObj=new CustomerInfo();
		for (int i = 0; i < customerObj.size(); i++) {
			if(cust_id==customerObj.get(i).getCustomer_id()) {
				custObj.setCustomer_id(customerObj.get(i).getCustomer_id());
				custObj.setAdderss(customerObj.get(i).getAdderss());
				custObj.setName(customerObj.get(i).getName());
				custObj.setPhonenumber(customerObj.get(i).getPhonenumber());
			}
		}
		return custObj;
	}

}
