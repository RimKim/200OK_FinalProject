package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import shop.myshop.entity.Answer;
import shop.myshop.entity.Question;
import shop.myshop.entity.User;

@Transactional
@Service
public interface AnswerService {
	
	 public Answer saveAnswer(Answer answer) throws Exception;
	 
	 public List<Answer> getAnswerList(int questionNo) throws Exception;
	  
	 public void deleteByAnswerNo(int answerNo) throws Exception;
	
}
