package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Product;


@Transactional
@Service
public interface OrderItemService {
	
	public void orderItemrSave(OrderItem orderItem) ;
	
	public List<Product> findByorderCode(int orderCode);
	
	
}
