package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	//카테고리번호조회
	Category findByCategoryNo(Integer categoryNo);
	
	
	

}
