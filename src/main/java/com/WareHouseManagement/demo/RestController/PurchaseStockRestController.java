package com.WareHouseManagement.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Service.PurchaseStockService;

@RestController
@RequestMapping("purchase")
public class PurchaseStockRestController {

	@Autowired
	PurchaseStockService purchaseService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createPurchase(@RequestBody PurchaseDetails purchase) {
		String status = purchaseService.insertPurchase(purchase);
		return status;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public List<PurchaseDetails> findOrders(@RequestBody String id) {
		List<PurchaseDetails> purchaseObj = purchaseService.displayDetails(id);
		return purchaseObj;
	}

	@RequestMapping(value = "/checkbyid", method = RequestMethod.POST)
	public PurchaseDetails findOrder(@RequestBody int id) {
		PurchaseDetails purchaseObj = purchaseService.findDetails(id);
		return purchaseObj;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteOrder(@RequestBody int id) {
		String purchaseObj = purchaseService.deleteDetails(id);
		return purchaseObj;
	}

}
