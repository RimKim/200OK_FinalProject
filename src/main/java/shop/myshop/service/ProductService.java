package shop.myshop.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.entity.Product;
import org.springframework.data.domain.Pageable;

@Service
public interface  ProductService {
	
	
	public List<Product> getAllProductsSortedBySales(Pageable pageable); 

	public List<ProductDTO> getProductListByCategory(Category categoryNo);
	

	public Product findByProductCode(@Param("productCode")int productCode);
	
	public List<Product> findProduct() throws Exception ;
	
	/*상품 이름 검색*/
	public List<Product> findByProductNameLikeIgnoreCase(String title) throws Exception;
	
	public void saveProduct(Product product) throws Exception;
	
	public void deleteProduct(int productCode) throws Exception;
	
	public List<String> findTop5ByOrderByProductSaleDesc() throws Exception;
	
	public List<Product> findByProductSale() throws Exception;
	
	public List<String> findWorst5ByOrderByProductSaleAsc() throws Exception;

}