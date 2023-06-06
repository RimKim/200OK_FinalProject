package shop.myshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
	
	
		
	@Query("select d from Delivery d where d.userId.userId=:userId")
	List<Delivery> getByUserId(@Param("userId")String userId) throws Exception;
	
	 
	 @Query("select deliveryId from Delivery d where d.userId.userId=:userId and deliveryBasicyn='Y'")
	 Integer getByDeliveryId(@Param("userId")String userId) throws Exception;
	 
	 //기본배송지설정 
	 @Modifying
	 @Transactional
	 @Query("update Delivery set deliveryBasicyn = 'N' where deliveryId=:deliveryId")
	 void updateBasicyn(@Param("deliveryId")int deliveryId) throws Exception;
	 
	 
	 @Query("select d from Delivery d where d.userId.userId = :userId and d.deliveryBasicyn = 'Y'")
	 Delivery findBydeliveryBasicynAndDeliveryId(@Param("userId") String userId) throws Exception;
	 
	 
	Delivery findByDeliveryId(int deliveryId);
	 
	
	 void deleteByDeliveryId(int deliveryId);
	
}
