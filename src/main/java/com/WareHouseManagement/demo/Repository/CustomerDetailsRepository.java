package com.WareHouseManagement.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.WareHouseManagement.demo.Bean.CustomerInfo;

public interface CustomerDetailsRepository extends CrudRepository<CustomerInfo, Integer>{

}
