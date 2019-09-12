package com.WareHouseManagement.demo.Controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.CustomerInfo;
import com.WareHouseManagement.demo.Bean.ItemInfo;
import com.WareHouseManagement.demo.Bean.Transactions;

@Controller
@RequestMapping("transactioncontrol")
public class BillingController {
	// this method is used for reading required details from the user and forwarding
	// the same to the rest control to add the transaction into db
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView customerCheck(String customer_id, String item_id, String quantity, HttpSession session) {
		String url = "http://localhost:8080/customer/check";
		RestTemplate rt = new RestTemplate();
		String status = rt.postForObject(url, customer_id, String.class);
		if (status.equals("Yes")) {
			url = "http://localhost:8080/item/check";
			status = rt.postForObject(url, item_id, String.class);
			if (status.equals("Yes")) {
				LocalDate transactiondate = java.time.LocalDate.now();
				Date transaction_date = Date.valueOf(transactiondate);
				ItemInfo itemobj = new ItemInfo();
				int itemid = Integer.parseInt(item_id);
				itemobj.setItem_id(itemid);
				CustomerInfo custobj = new CustomerInfo();
				int custid = Integer.parseInt(customer_id);
				custobj.setCustomer_id(custid);
				int quant = Integer.parseInt(quantity);
				if (quant > 0) {
					Transactions tranobj = new Transactions();
					tranobj.setCustObj(custobj);
					tranobj.setItemObj(itemobj);
					tranobj.setQuantity(quant);
					tranobj.setTransaction_date(transaction_date);
					url = "http://localhost:8080/transactions/insert";
					status = rt.postForObject(url, tranobj, String.class);
					url = "http://localhost:8080/item/reduceStock";
					String status1 = rt.postForObject(url, tranobj, String.class);
					ModelAndView mv = new ModelAndView("Error.jsp");
					mv.addObject("obj", status);
					mv.addObject("obj1", status1);
					return mv;
				} else {
					ModelAndView mv = new ModelAndView("Error.jsp");
					status = "Quantity must be a positive value";
					mv.addObject("obj", status);
					return mv;

				}
			} else {
				ModelAndView mv = new ModelAndView("Error.jsp");
				String obj = "item not found";
				mv.addObject("obj", obj);
				return mv;
			}
		} else {
			ModelAndView mv = new ModelAndView("Error.jsp");
			String obj = "customer not found";
			mv.addObject("obj", obj);
			return mv;
		}
	}

}
