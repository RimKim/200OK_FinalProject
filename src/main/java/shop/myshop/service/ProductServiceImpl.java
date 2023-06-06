package shop.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Category;
import shop.myshop.entity.Product;
import shop.myshop.entity.User;
import shop.myshop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productDao;
	
	public List<Product> getAllProductsSortedBySales(Pageable pageable) {
		return productDao.findAllOrderByProductSaleDesc(pageable);
	}

	@Override
	public List<ProductDTO> getProductListByCategory(Category categoryNo) {
		List<Product> productList = productDao.findByCategoryNo(categoryNo);
		List<ProductDTO> productDtoList = new ArrayList<>();

		for (Product product : productList) {
			ProductDTO productDto = new ProductDTO();
			BeanUtils.copyProperties(product, productDto);
			productDtoList.add(productDto);
		}

		return productDtoList;
	}

	

	@Override
	public Product findByProductCode(@Param("productCode") int productCode) {
		return productDao.findByProductCode(productCode);
	}

	@Override
	public List<Product> findProduct() throws Exception {
		return productDao.findAll();
	}

	@Override
	public List<Product> findByProductNameLikeIgnoreCase(String title) throws Exception {
		return productDao.findByProductNameLikeIgnoreCase("%" + title + "%");

	}

	@Override
	public void saveProduct(Product product) throws Exception {
		productDao.save(product);
	}

	@Override
	public void deleteProduct(int productCode) throws Exception {
		productDao.deleteById(productCode);
	}

	@Override
	public List<String> findTop5ByOrderByProductSaleDesc() throws Exception{
		
		Pageable pageable = PageRequest.of(0, 5);
		List<String> top5Products = productDao.findTop5ByOrderByProductSaleDesc(pageable);
		return top5Products;
	}
	@Override
	public List<Product> findByProductSale() throws Exception{
		return productDao.findByProductSale();
	}
	@Override
	public List<String> findWorst5ByOrderByProductSaleAsc() throws Exception{
		Pageable pageable = PageRequest.of(0, 5);
		List<String> wordt5Products = productDao.findWorst5ByOrderByProductSaleAsc(pageable);
		return wordt5Products;
	}
}
