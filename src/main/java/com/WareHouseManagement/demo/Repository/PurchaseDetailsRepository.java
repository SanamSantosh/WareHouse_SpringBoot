package com.WareHouseManagement.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.WareHouseManagement.demo.Bean.PurchaseDetails;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer>{
	
	@Query("from PurchaseDetails where merchant_id=?1 order by purchase_id")
	List<PurchaseDetails> findByMerchant_idSorted(int merchantid);

}
