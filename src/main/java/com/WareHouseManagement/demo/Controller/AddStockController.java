package com.WareHouseManagement.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.ItemInfo;


@Controller
public class AddStockController {
	
	//this method is used for reading item id from the user and forwarding
	//the same to the rest control to get the item details
	@RequestMapping(value="checkItem" , method = RequestMethod.POST)
	public ModelAndView CheckItem( String item_id,HttpSession session)
	{
		String url="http://localhost:8080/item/check";
		RestTemplate rt=new RestTemplate();
		String  status=rt.postForObject(url, item_id, String.class);
	    if(status.equals("Yes")) {
	    	url="http://localhost:8080/item/display";
	    	ItemInfo item=rt.postForObject(url, item_id, ItemInfo.class);
	    	session.setAttribute("itemobj", item);
	    	ModelAndView mv=new ModelAndView("ItemInfo1.jsp");
	    	mv.addObject("obj",item);
	    	return mv;
	    }
	    else {
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("NewItem.jsp");
	    	return mv;
	    }
		
	}
	
	//this method is used for reading stock from the user and forwarding
		//the same to the rest control to add to the item details
	@RequestMapping(value="addStock" , method = RequestMethod.POST)
	public ModelAndView addStock( String stock,HttpSession session)
	{
		ModelAndView mv=new ModelAndView("Error.jsp");
		RestTemplate rt=new RestTemplate();
		ItemInfo itemobj=(ItemInfo)session.getAttribute("itemobj");
		int itemid=itemobj.getItem_id();
		System.out.println(itemid);
		String url="http://localhost:8080/item/addstock/"+itemid;
		String  status=rt.postForObject(url, stock, String.class);
	    if(status.equals("Yes")) {
	    	mv.addObject("obj",status);
	    	return mv;
	    }
	    else {
	    	mv.addObject("obj",status);
	    	return mv;
	    }
		
	}

}
