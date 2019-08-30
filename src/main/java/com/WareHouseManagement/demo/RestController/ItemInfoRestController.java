package com.WareHouseManagement.demo.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.ItemInfo;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Bean.Transactions;
import com.WareHouseManagement.demo.Service.ItemInfoService;

@RestController
@RequestMapping("item")
public class ItemInfoRestController {
	
	
	@Autowired
	ItemInfoService itemService;
	
	//this method is for checking for the item db operations handled in service
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	   public String findItem(@RequestBody String item) {  
		ItemInfo itemObj=itemService.check(item);
		   String status;
		   if (itemObj.getName()!=null)
			   status="Yes";
		   else
			   status="No";
			return status; 
	   }
	
	//this method is for adding new item db operations handled in service
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	   public String createItem(@RequestBody ItemInfo item) {
		   String status=itemService.createItem(item);
			return status; 
	   }
	
	//this method is for getting item details db operations handled in service
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	   public ItemInfo displayItem(@RequestBody String item) {
		ItemInfo status=itemService.displayItem(item);
			return status; 
	   }
	
	//this method is for updating stock db operations handled in service
	@RequestMapping(value = "/addstock/{id}", method = RequestMethod.POST)
	   public String addStock(@RequestBody String stock,@PathVariable("id") int id) {
		System.out.println("-------------"+id);
		String status=itemService.addStock(id,stock);
			return status; 
	   }
	
	//this method is for updating stock when purchase is made db operations handled in service
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	   public String updateStock(@RequestBody PurchaseDetails purchase) {
		   String status=itemService.updateStock(purchase);
			return status; 
	   }
	
	//this method is for updating the stock when billing is done db operations handled in service
	@RequestMapping(value = "/reduceStock", method = RequestMethod.POST)
	   public String reduceStock(@RequestBody Transactions tranobj) {
		   String status=itemService.reduceStock(tranobj);
			return status; 
	   }

}
