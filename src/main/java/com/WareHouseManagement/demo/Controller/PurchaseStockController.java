package com.WareHouseManagement.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.MerchantStock;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;

@Controller
@RequestMapping("purchasecontrol")
public class PurchaseStockController {
	
	//this method is used for reading required details from the user and forwarding
			//the same to the rest control to place an order to merchant
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addPurchase( String stockid,String merchantid,String quantity)
	{
		int sid=Integer.parseInt(stockid);
		int mid=Integer.parseInt(merchantid);
		int quant=Integer.parseInt(quantity);
		MerchantStock merchantobj=new MerchantStock();
		merchantobj.setStock_id(sid);
		PurchaseDetails purchaseObj=new PurchaseDetails();
		purchaseObj.setQuantity(quant);
		purchaseObj.setMerchant_id(mid);
		purchaseObj.setMerchantObj(merchantobj);
		String url="http://localhost:8080/purchase/insert";
		RestTemplate rt=new RestTemplate();
		String  status=rt.postForObject(url, purchaseObj, String.class);
	    ModelAndView mv=new ModelAndView("Error.jsp");
	    mv.addObject("obj",status);
		return mv;
	}

}
