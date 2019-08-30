package com.WareHouseManagement.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.MerchantStock;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Repository.MerchantRepository;

@Service
@Component
@EnableAutoConfiguration
public class MerchantService {
	
	@Autowired
	MerchantRepository merchantRepo;
	
	//this method is for creating merchant
	public String createMerchant(MerchantStock merchantobj) {
		merchantRepo.save(merchantobj);
		   String status;
		   if (merchantobj!=null)
			   status="Merchant Stock details created";
		   else
			   status="Merchant Stock details creation unsuccessful";
			return status; 
	}
	
	//to get the list of merchants
	public List<MerchantStock> displayDetails() {
		List<MerchantStock> merchantObj=(List<MerchantStock>) merchantRepo.findAll();
		return merchantObj;
	}
	
	//to get the list of merchants based on stockid
	public MerchantStock displayFilteredDetails(int stockid){
		MerchantStock merchantObj=merchantRepo.findById(stockid).orElse(new MerchantStock());
		return merchantObj;
	}
	
	//this method is for updating the stock when a purchase has been made
	public String updateStock(PurchaseDetails purchase) {
			
			MerchantStock merchant=merchantRepo.findById(purchase.getMerchantObj().getStock_id()).orElse(new MerchantStock());
		    merchant.setStock(merchant.getStock()-purchase.getQuantity());
		    merchantRepo.save(merchant);
			String status="Merchant Stock Reduced";
			return status; 
	}

}
