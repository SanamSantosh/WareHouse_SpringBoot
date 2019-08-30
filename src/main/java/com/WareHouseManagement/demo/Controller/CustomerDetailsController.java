package com.WareHouseManagement.demo.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.CustomerInfo;

@Controller
@RequestMapping("customerdetailscontrol")
public class CustomerDetailsController {

	//this method is used for reading customer id from the user and forwarding
		//the same to the rest control to get the customer details
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck( String customer_id,HttpSession session)
	{
		String url="http://localhost:8080/customer/check";
		RestTemplate rt=new RestTemplate();
		session.setAttribute("custid",customer_id);
		String  status=rt.postForObject(url, customer_id, String.class);
	    if(status.equals("Yes")) {
	    	url="http://localhost:8080/customer/display";
	    	CustomerInfo cust=rt.postForObject(url, customer_id, CustomerInfo.class);
	    	ModelAndView mv=new ModelAndView("CustomerInfo.jsp");
	    	mv.addObject("obj",cust);
	    	return mv;
	    }
	    else {
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("CreateCustomer.jsp");
	    	return mv;
	    }
		
	}

}
