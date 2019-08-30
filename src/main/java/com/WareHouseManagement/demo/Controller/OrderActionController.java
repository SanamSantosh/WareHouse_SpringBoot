package com.WareHouseManagement.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.PurchaseDetails;

@Controller
@RequestMapping("orderactioncontrol")
public class OrderActionController {
	
	//this method is used for reading accept/reject from the user and forwarding
			//the same to the rest control to perform the action
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView orderAction( String action,int purchaseid)
	{
		ModelAndView mv=new ModelAndView("Error1.jsp");
		String url="http://localhost:8080/purchase/checkbyid";
		RestTemplate rt=new RestTemplate();
		String status,status1;
		PurchaseDetails  purchaseObj=rt.postForObject(url, purchaseid, PurchaseDetails.class);
		
		if (action.equals("accept")) {
		url="http://localhost:8080/purchase/delete";
		status=rt.postForObject(url, purchaseid, String.class);
	    if(status.equals("Yes")) {
	    	url="http://localhost:8080/merchant/update";
			status=rt.postForObject(url, purchaseObj, String.class);
			url="http://localhost:8080/item/update";
			status1=rt.postForObject(url, purchaseObj, String.class);
			mv.addObject("obj",status);
			mv.addObject("obj1",status1);
	    	return mv;
	    }
	    else {
	    	status="No transaction";
	    	mv.addObject("obj",status);
	    	return mv;
	    }
		}
		else {
			url="http://localhost:8080/purchase/delete";
			status=rt.postForObject(url, purchaseid, String.class);
		if(status.equals("Yes")) {
			status="Order Rejected";
	    	mv.addObject("obj",status);
	    	return mv;
		}
		else {
			status="No transaction";
	    	mv.addObject("obj",status);
	    	return mv;
		}
		}
	}

}
