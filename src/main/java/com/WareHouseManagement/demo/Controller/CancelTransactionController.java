package com.WareHouseManagement.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("cancelTransactionControl")
public class CancelTransactionController {
	
	//this method is used for reading transaction id from the user and forwarding
		//the same to the rest control to delete the transaction fromdb
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck( String transaction_id,HttpSession session)
	{
		String url="http://localhost:8080/transactions/delete";
		RestTemplate rt=new RestTemplate();
		String  status=rt.postForObject(url, transaction_id, String.class);
	    ModelAndView mv =new ModelAndView("Error.jsp");
	    mv.addObject("obj",status);
	    return mv;
		
	}

}
