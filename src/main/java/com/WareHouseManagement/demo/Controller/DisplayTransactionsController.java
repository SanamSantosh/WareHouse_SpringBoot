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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.WareHouseManagement.demo.Bean.Transactions;

@Controller
@RequestMapping("displayTransaction")
public class DisplayTransactionsController {

	// this method is used for getting the list of transaction details from the rest
	// controller
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView CheckTransaction(String transaction_date, HttpSession session) {
		String url = "http://localhost:8080/transactions/check";
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<>(transaction_date, requestHeaders);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List<Transactions>> status = rt.exchange(url, HttpMethod.POST, requestEntity,
				new ParameterizedTypeReference<List<Transactions>>() {
				});
		ModelAndView mv = new ModelAndView("ViewTransactions.jsp");
		mv.addObject("obj", status.getBody());
		return mv;

	}

}
