package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Cart;
import shop.myshop.entity.Product;


@Transactional
@Service
public interface CartService {
	
	public int getCartCount(String userId) throws Exception;
	
	public List<Product> getProductCode(String userId) throws Exception;
	
	public List<Integer> getCartQuantity(String userId) throws Exception;
	
	public Cart getCart(String userId,int productCode) throws Exception;
	
	public void deleteByUserIdAndProductCode(String userId, int productCode) throws Exception;
	
	public void saveCart(Cart cart) throws Exception;
	
}
