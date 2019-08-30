package com.WareHouseManagement.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.WareHouseManagement.demo.Bean.ItemInfo;

@Repository
public interface ItemInfoRepository extends JpaRepository<ItemInfo, Integer>{
	@Modifying(clearAutomatically = true)
	@Query("UPDATE ItemInfo i SET i.stock= :stock WHERE i.item_id= :itemid")
	public int updateStock(@Param("itemid") int itemid, @Param("stock") int stock);

}
