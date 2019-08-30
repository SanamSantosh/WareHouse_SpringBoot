package com.WareHouseManagement.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.MerchantStock;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Service.MerchantService;

@RestController
@RequestMapping("merchant")
public class MerchantRestController {
	@Autowired
	MerchantService merchantService;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String createMerchant(@RequestBody MerchantStock merchantobj) {
		   String status=merchantService.createMerchant(merchantobj);
			return status; 
	   }
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	   public List<MerchantStock> findTransaction() {  
		List<MerchantStock> MerchnatObj=merchantService.displayDetails();
		 return MerchnatObj; 
	   }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	   public String updateStock(@RequestBody PurchaseDetails purchase) {
		   String status=merchantService.updateStock(purchase);
			return status; 
	   }

}
