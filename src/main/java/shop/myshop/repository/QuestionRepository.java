package shop.myshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	  @Query(value = "select q FROM Question q where questionNo=:questionNo")
	  Question findByQuestion(@Param("questionNo")int questionNo);
	  
	  List<Question> findByQuestionNo(int QuestionNo) throws Exception;
	
	  @Query(value = "select q FROM Question q ORDER BY  questionNo DESC")
	  List<Question> getQuestion() throws Exception;
	  
	  @Modifying
	  @Transactional 
	  void deleteByQuestionNo(int QuestionNo);
	 
	 @Query("SELECT COUNT(q) FROM Question q WHERE q.userId.userId = :userId")
	 int getQuestionwCount(@Param("userId") String userId);

}
