package shop.myshop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import shop.myshop.entity.Answer;
import shop.myshop.entity.Question;
import shop.myshop.entity.User;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	
	//답변조회
	 List<Answer> findByQuestionNoOrderByAnswerRegdateAsc(Question questionNo);
	 
	 @Modifying
	 @Transactional
	 void deleteByAnswerNo(int answerNo); //답변삭제
	
}
