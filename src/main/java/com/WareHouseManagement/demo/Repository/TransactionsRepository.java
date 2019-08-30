package com.WareHouseManagement.demo.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.WareHouseManagement.demo.Bean.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer>{
	
	@Query("from Transactions where transaction_date=?1 order by transaction_id")
	List<Transactions> findByTransaction_dateSorted(Date trandate);

}
