package com.WareHouseManagement.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.MerchantStock;
import com.WareHouseManagement.demo.Bean.PurchaseDetails;

@Controller
public class ViewOrdersController {

	@RequestMapping("vieworders")
	public ModelAndView viewOrders(HttpSession session) {

		String id = (String) session.getAttribute("merchant_id");
		String url = "http://localhost:8080/purchase/check";
		String url1 = "http://localhost:8080/merchant/check";
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(id, requestHeaders);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<PurchaseDetails>> purchaseObj = rt.exchange(url, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<PurchaseDetails>>() {
				});
		HttpEntity<String> requestEntity1 = new HttpEntity<>(null, requestHeaders);
		ResponseEntity<List<MerchantStock>> merchantObj = rt.exchange(url1, HttpMethod.GET, requestEntity1,
				new ParameterizedTypeReference<List<MerchantStock>>() {
				});
		ModelAndView mv = new ModelAndView("ViewOrders.jsp");
		mv.addObject("obj", purchaseObj.getBody());
		mv.addObject("obj1", merchantObj.getBody());
		return mv;

	}

}
