package com.WareHouseManagement.demo.Controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.ItemInfo;

@Controller
@RequestMapping("iteminfocontrol")
public class ItemInfoController {
	
	//this method is used for reading item id from the user and forwarding
		//the same to the rest control to get the item details
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView itemCheck( String item_id,HttpSession session)
	{
		session.setAttribute("item_id", item_id);
	String url="http://localhost:8080/item/check";
	RestTemplate rt=new RestTemplate();
	String  status=rt.postForObject(url, item_id, String.class);
    if(status.equals("Yes")) {
    	url="http://localhost:8080/item/display";
    	ItemInfo item=rt.postForObject(url, item_id, ItemInfo.class);
    	ModelAndView mv=new ModelAndView("ItemInfo.jsp");
    	int discount=0;
    	int price=(int)item.getPrice();
    	int difference;
    	if(item.getPrice()>10 || item.getPrice()<100){
    		difference = (int) (price * 0.1);
    	discount=(price-difference);
    	}
    	if(item.getPrice()>100){
    		difference = (int) (price * 0.2);
    	discount=(price-difference);
    	}
    	if(item.getPrice()<10){
    	discount=price;
    	}
    	mv.addObject("obj",item);
    	mv.addObject("obj1",discount);
    	return mv;
    }
    else {
    	ModelAndView mv=new ModelAndView();
    	mv.setViewName("NewItem.jsp");
    	return mv;
    }
	}

}
