package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.entity.Question;


@Transactional
@Service
public interface QuestionService {
	
	  public int getQuestionCount(String userId);
	
	  public void saveQuestion(Question Question) throws Exception;
	  
	  public void deleteByQuestionNo(int QuestionNo) throws Exception;
	  
	  public  List<Question> findByQuestionNo(int QuestionNo) throws Exception;
	  public Question findByQuestion(int QuestionNo) throws  Exception;
	  
	 public List<Question> getQuestion() throws Exception;
	 
}
