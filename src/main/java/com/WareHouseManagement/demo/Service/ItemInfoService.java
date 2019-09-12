package com.WareHouseManagement.demo.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.ItemInfo;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;
import com.WareHouseManagement.demo.Bean.Transactions;
import com.WareHouseManagement.demo.Repository.ItemInfoRepository;

@Service
@Component
@EnableAutoConfiguration
public class ItemInfoService {

	@Autowired
	ItemInfoRepository itemRepo;

	// this method is for checking for the item
	public String check(String itemid) {
		int item_id = Integer.parseInt(itemid);
		Optional<ItemInfo> item = itemRepo.findById(item_id);
		String status;
		if (item.isPresent())
			status = "Yes";
		else
			status = "No";
		return status;
	}

	// this method is for adding new item
	public String createItem(ItemInfo item) {
		itemRepo.save(item);
		String status;
		if (item.getName() != null)
			status = "Item Created with item_id: " + item.getItem_id();
		else
			status = "item creation unsuccessful";
		return status;
	}

	// this method is for getting item details
	public ItemInfo displayItem(String itemid) {
		int item_id = Integer.parseInt(itemid);
		ArrayList<ItemInfo> item = (ArrayList<ItemInfo>) itemRepo.findAll();
		ItemInfo itemObj = new ItemInfo();
		for (int i = 0; i < item.size(); i++) {
			if (item_id == item.get(i).getItem_id()) {
				itemObj.setItem_id(item.get(i).getItem_id());
				itemObj.setPrice(item.get(i).getPrice());
				itemObj.setName(item.get(i).getName());
				itemObj.setStock(item.get(i).getStock());
			}
		}
		return itemObj;
	}

	// this method is for updating stock
	public String addStock(int id, String stock) {
		int stock1 = Integer.parseInt(stock);
		ItemInfo itemobj = itemRepo.findById(id).orElse(new ItemInfo());
		itemobj.setStock(itemobj.getStock() + stock1);
		itemRepo.save(itemobj);
		String reply = "Stock Changed to " + itemobj.getStock();
		return reply;
	}

	// this method is for updating stock when purchase is made
	public String updateStock(PurchaseDetails purchase) {

		ItemInfo item = itemRepo.findById(purchase.getMerchantObj().getItemObj().getItem_id()).orElse(new ItemInfo());
		item.setStock(item.getStock() + purchase.getQuantity());
		itemRepo.save(item);
		String status = "Item Stock Increased";
		return status;
	}

	// this method is for updating the stock when billing is done
	public String reduceStock(Transactions tranobj) {

		ItemInfo item = itemRepo.findById(tranobj.getItemObj().getItem_id()).orElse(new ItemInfo());
		if (item.getStock() >= tranobj.getQuantity() && item.getStock() - tranobj.getQuantity() > 0)
			item.setStock(item.getStock() - tranobj.getQuantity());
		itemRepo.save(item);
		String status = "Item Stock reduced";
		return status;
	}

}
