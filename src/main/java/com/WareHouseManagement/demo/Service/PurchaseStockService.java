package com.WareHouseManagement.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Repository.PurchaseDetailsRepository;

@Service
@Component
@EnableAutoConfiguration
public class PurchaseStockService {

	@Autowired
	PurchaseDetailsRepository purchaseRepo;

	// this method is for inserting an order into db
	public String insertPurchase(PurchaseDetails purchase) {
		purchaseRepo.save(purchase);
		String status;
		if (purchase != null)
			status = "Order Placed Order Id: " + purchase.getPurchase_id();
		else
			status = "Error while placing order";
		return status;
	}

	// this method is for getting list of orders based on merchantid
	public List<PurchaseDetails> displayDetails(String merchantid) {
		int id = Integer.parseInt(merchantid);
		List<PurchaseDetails> purchaseObj = (List<PurchaseDetails>) purchaseRepo.findByMerchant_idSorted(id);
		return purchaseObj;
	}

	// this method is for finding a order based on purchase id
	public PurchaseDetails findDetails(int purchaseid) {
		PurchaseDetails purchaseObj = purchaseRepo.findById(purchaseid).orElse(new PurchaseDetails());
		return purchaseObj;
	}

	// this method is for deleting a order
	public String deleteDetails(int purchaseid) {
		PurchaseDetails purchaseObj = purchaseRepo.findById(purchaseid).orElse(new PurchaseDetails());
		if (purchaseObj != null) {
			purchaseRepo.deleteById(purchaseid);
			return "Yes";
		} else
			return "No";
	}

}
