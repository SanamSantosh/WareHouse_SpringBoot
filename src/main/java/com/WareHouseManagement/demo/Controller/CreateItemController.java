package com.WareHouseManagement.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.ItemInfo;

@Controller
@RequestMapping("createitem")
public class CreateItemController {
	
	//this method is used for reading required details from the user and forwarding
		//the same to the rest control to create a new  item 
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck( ItemInfo itemObj)
	{
		ModelAndView mv=new ModelAndView("Error.jsp");
		String url="http://localhost:8080/item/insert";
		RestTemplate rt=new RestTemplate();
		String  status=rt.postForObject(url, itemObj, String.class);
	    mv.addObject("obj",status);
	    	return mv;
		
	}

}
