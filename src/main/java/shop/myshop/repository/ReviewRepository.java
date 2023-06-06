package shop.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	@Query("SELECT COUNT(r) FROM Review r WHERE r.userId.userId = :userId")
	int getReviewCount(@Param("userId") String userId);

}
