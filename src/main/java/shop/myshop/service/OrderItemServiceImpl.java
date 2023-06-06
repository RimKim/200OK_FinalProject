package shop.myshop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.OrderItem;
import shop.myshop.entity.Product;
import shop.myshop.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void orderItemrSave(OrderItem orderItem) {
		orderItemDao.save(orderItem);
	}

	@Override
	public List<Product> findByorderCode(int orderCode) {
		return orderItemDao.findByorderCode(orderCode);
	}

}
