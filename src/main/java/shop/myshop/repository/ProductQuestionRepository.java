package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.ProductQuestion;

@Repository
public interface ProductQuestionRepository extends JpaRepository<ProductQuestion, Integer> {
	
	@Query("SELECT COUNT(q) FROM Productquestion q WHERE q.userId.userId = :userId")
	int getProductQuestionCount(@Param("userId") String userId);

}
