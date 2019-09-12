package com.WareHouseManagement.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WareHouseManagement.demo.Bean.Login;

public interface LoginRepository extends JpaRepository<Login,String>{

}
