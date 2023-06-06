package shop.myshop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Orders;
import shop.myshop.repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getOrdersCount(String userId, String orderStatus) {
		return ordersDao.getOrdersCount(userId, orderStatus);
	}

	@Override
	public void orderSave(Orders orders) {
		ordersDao.save(orders);
	}

	@Override
	public List<Orders> findOrder() {
		return ordersDao.findAll();
	}

	@Override
	public void deleteOrders(int orderCode) {
		ordersDao.deleteById(orderCode);
	}

	@Override
	public Orders findByOrdersCode(int ordersCode) {
		return ordersDao.findByOrderCode(ordersCode);
	}

	@Override
	public List<Orders> findByRegDateDesc() {
		return ordersDao.findByRegDateDesc();
	}

	@Override
	public List<Integer> findByUserId(String userId) {
		return ordersDao.findByUserId(userId);
	}

}
