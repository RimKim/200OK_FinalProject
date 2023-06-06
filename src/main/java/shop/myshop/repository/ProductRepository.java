package shop.myshop.repository;

import org.springframework.data.domain.Pageable ;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Category;
import shop.myshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	//best상품
	@Query("SELECT p FROM Product p ORDER BY p.productSale DESC")
	List<Product> findAllOrderByProductSaleDesc(Pageable pageable);
	
	//카테고리별 상품조회
	@Query(value="select p from Product p where p.categoryNo=:categoryNo")
	 List<Product> findByCategoryNo(@Param("categoryNo")Category categoryNo);
	
	Product findByProductCode(@Param("productCode")int productCode);
	
	/*상품 이름 검색 IgnoreCase(대소문자 구분 무시)*/
	List<Product> findByProductNameLikeIgnoreCase(String title);
	
	//상품 판매량 상위 5개 
	//select * from product order by product_sale desc limit 5;
	@Query("SELECT p.productName,p.productSale FROM Product p ORDER BY p.productSale DESC")
	List<String> findTop5ByOrderByProductSaleDesc(Pageable pageable);
	
	@Query("SELECT p.productName,p.productSale FROM Product p ORDER BY p.productSale ASC")
	List<String> findWorst5ByOrderByProductSaleAsc(Pageable pageable);
	
	@Query("select p from Product p where productStock < 10")
	List<Product> findByProductSale();
}
