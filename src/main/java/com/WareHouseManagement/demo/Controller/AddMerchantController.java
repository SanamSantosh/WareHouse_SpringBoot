package com.WareHouseManagement.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.ItemInfo;
import com.WareHouseManagement.demo.Bean.MerchantDetails;
import com.WareHouseManagement.demo.Bean.MerchantStock;

@Controller
@RequestMapping("addmerchantControl")
public class AddMerchantController {
	
	//this method is for reading merchant details from the user and pass them to the rest
	//controller to add the new merchant to the db.
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addMerchant( String stockid,String itemid,String merchantid,String price,String stock)
	{
		String url="http://localhost:8080/merchant/insert";
		RestTemplate rt=new RestTemplate();
		int stock_id=Integer.parseInt(stockid);
		int item_id=Integer.parseInt(itemid);
		int merchant_id=Integer.parseInt(merchantid);
		float mprice=Float.parseFloat(price); 
		int mstock=Integer.parseInt(stock);
		ItemInfo itemobj=new ItemInfo();
		itemobj.setItem_id(item_id);
		MerchantDetails merchantobj=new MerchantDetails();
		merchantobj.setMerchant_id(merchant_id);
		MerchantStock stockobj=new MerchantStock();
		stockobj.setItemObj(itemobj);
		stockobj.setMerchantObj(merchantobj);
		stockobj.setPrice(mprice);
		stockobj.setStock(mstock);
		stockobj.setStock_id(stock_id);
		String  status=rt.postForObject(url, stockobj, String.class);
	    ModelAndView mv=new ModelAndView("Error.jsp");
	    mv.addObject("obj",status);
	    return mv;
		
	}

}
