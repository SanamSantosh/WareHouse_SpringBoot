package com.WareHouseManagement.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WareHouseManagement.demo.Bean.MerchantStock;

public interface MerchantRepository extends JpaRepository<MerchantStock, Integer>{

}
