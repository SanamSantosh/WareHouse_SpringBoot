package com.WareHouseManagement.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WareHouseManagement.demo.Bean.MerchantDetails;

public interface MerchantLoginRepository extends JpaRepository<MerchantDetails, Integer>{

}
