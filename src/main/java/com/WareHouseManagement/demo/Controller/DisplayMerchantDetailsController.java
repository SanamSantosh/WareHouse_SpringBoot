package com.WareHouseManagement.demo.Controller;

import java.util.List;

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

@Controller
public class DisplayMerchantDetailsController {
	// this method is used for getting the list of merchant details from the rest
	// controller
	@RequestMapping("displayMerchantDetails")
	public ModelAndView CheckMerchantDetails() {
		String url = "http://localhost:8080/merchant/check";
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<MerchantStock>> status = rt.exchange(url, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<MerchantStock>>() {
				});
		ModelAndView mv = new ModelAndView("DisplayMerchantDetails.jsp");
		mv.addObject("obj", status.getBody());
		return mv;

	}

}
