package shop.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	@Query("select o.productCode from Orderitem o where o.orderCode.orderCode=:orderCode")
	List<Product> findByorderCode(@Param("orderCode") int orderCode);
    
	
}
