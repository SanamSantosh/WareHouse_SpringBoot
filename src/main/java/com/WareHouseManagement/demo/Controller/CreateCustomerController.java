package com.WareHouseManagement.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.CustomerInfo;

@Controller
@RequestMapping("createcustomer")
public class CreateCustomerController {

	// this method is used for reading required details from the user and forwarding
	// the same to the rest control to create a new customer
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck(CustomerInfo custObj, HttpSession session) {
		String url = "http://localhost:8080/customer/insert";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, custObj, String.class);
		ModelAndView mv = new ModelAndView("Error.jsp");
		mv.addObject("obj", status);
		return mv;
	}

}
