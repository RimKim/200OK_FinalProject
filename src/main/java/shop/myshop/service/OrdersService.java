package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;


@Transactional
@Service
public interface OrdersService {
	
	public int getOrdersCount(String userId,String orderStatus);
	
	public void orderSave(Orders orders);
	
	public List<Orders> findOrder();
	
	public void deleteOrders(int orderCode);
	
	public Orders findByOrdersCode(int ordersCode);
	
	public List<Orders> findByRegDateDesc();
	
	public List<Integer> findByUserId(String userId); 
	
	
	
}
