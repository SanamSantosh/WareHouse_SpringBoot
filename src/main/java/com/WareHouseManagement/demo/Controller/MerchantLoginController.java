package com.WareHouseManagement.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.MerchantDetails;

@Controller
@RequestMapping("merchantlogincontrol")
public class MerchantLoginController {

	//this method is used for reading user id and password from the user and forwarding
			//the same to the rest control to validate the credentials
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView merchantlogincontrol( String merchant_id,String password,HttpSession session)
	{
		session.setAttribute("merchant_id", merchant_id);
		String url="http://localhost:8080/merchantlogin/check";
		RestTemplate rt=new RestTemplate();
		ModelAndView mv=new ModelAndView();
		int id=Integer.parseInt(merchant_id);
		MerchantDetails merchantLoginObj=new MerchantDetails();
		merchantLoginObj.setMerchant_id(id);
		merchantLoginObj.setPassword(password);
		String  status=rt.postForObject(url, merchantLoginObj, String.class);
		
	    if(status.equals("Yes")) {
	    	mv.setViewName("MerchantHomePage.jsp");;
	    	return mv;
	    }
	    else {
	    	String reply="Invalid Credentials";
	    	mv.setViewName("loginvalidation.jsp");
	    	mv.addObject("obj",reply);
	    	return mv;
	    }
	}

}
