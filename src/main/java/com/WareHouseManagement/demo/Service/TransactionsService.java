package com.WareHouseManagement.demo.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.WareHouseManagement.demo.Bean.Transactions;
import com.WareHouseManagement.demo.Repository.TransactionsRepository;

@Service
@Component
@EnableAutoConfiguration
public class TransactionsService {
	
	@Autowired
	TransactionsRepository transactionsRepo;
	//this method is used for adding transaction
	public String createTransaction(Transactions tran) {
		transactionsRepo.save(tran);
		   String status;
		   if (tran.getTransaction_date()!=null)
			   status="Transaction Successful with transaction Id: "+tran.getTransaction_id();
		   else
			   status="Transaction failed";
			return status; 
	}
	
	//this method is for getting the list of transactions
	public List<Transactions> displayTransactions(String tdate) {
		Date trandate=Date.valueOf(tdate);
		List<Transactions> tranObj=(List<Transactions>) transactionsRepo.findByTransaction_dateSorted(trandate);
		return tranObj;
	}
	
	//this method is for deleting a transaction
	public String deleteTransaction(String tranid) {
		int transaction_id=Integer.parseInt(tranid);
		Optional<Transactions> tranobj=transactionsRepo.findById(transaction_id);
		String reply;
		if(tranobj.get().getTransaction_date()!=null) {
		transactionsRepo.deleteById(transaction_id);
		    reply="Transaction deleted successfully";
		}
		else
			 reply="Transaction not found";
		return reply;
	}

}
