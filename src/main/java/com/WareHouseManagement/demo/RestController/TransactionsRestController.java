package com.WareHouseManagement.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WareHouseManagement.demo.Bean.Transactions;
import com.WareHouseManagement.demo.Repository.TransactionsRepository;
import com.WareHouseManagement.demo.Service.TransactionsService;

@RestController
@RequestMapping("transactions")
public class TransactionsRestController {
	@Autowired
	TransactionsRepository transactionrepo;
	@Autowired
	TransactionsService transactionsService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createTransactrion(@RequestBody Transactions tran) {
		String status = transactionsService.createTransaction(tran);
		return status;
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public List<Transactions> findTransaction(@RequestBody String trandate) {
		List<Transactions> tranObj = transactionsService.displayTransactions(trandate);
		return tranObj;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteTransactrion(@RequestBody String tranid) {
		String status = transactionsService.deleteTransaction(tranid);
		return status;
	}

}
