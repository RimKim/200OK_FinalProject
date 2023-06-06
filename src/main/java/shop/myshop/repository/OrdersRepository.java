package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
	
	
	@Query("SELECT COUNT(o) FROM Orders o WHERE o.userId.userId=:userId and orderStatus=:orderStatus")
	int getOrdersCount(@Param("userId") String userId ,@Param("orderStatus") String orderStatus);

	Orders findByOrderCode(@Param("orderCode") int orderCode);
	
	@Query("SELECT o FROM Orders o ORDER BY o.orderRegdate DESC")
    	List<Orders> findByRegDateDesc();
	
	@Query("SELECT o.orderCode From Orders o where o.userId.userId = :userId AND o.orderStatus != '배송완료'")
	List<Integer> findByUserId(@Param("userId") String userId); 
	
}
