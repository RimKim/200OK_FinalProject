package shop.myshop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Answer;
import shop.myshop.entity.Question;
import shop.myshop.entity.User;
import shop.myshop.repository.AnswerRepository;
import shop.myshop.repository.QuestionRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	

   	 @Autowired
    	 private AnswerRepository answerDao;
    
    	@Autowired 
    	private QuestionService questionService;

    
	public Answer saveAnswer(Answer answer) throws Exception {
        		
		return answerDao.save(answer);
    	}
    
   	@Override
    	public List<Answer> getAnswerList(int questionNo) throws Exception {
       		
		 Question question = questionService.findByQuestion(questionNo);
        		
		return answerDao.findByQuestionNoOrderByAnswerRegdateAsc(question);
    	}
	
	@Override
	public void deleteByAnswerNo(int answerNo) throws Exception {
		 
		answerDao.deleteByAnswerNo(answerNo);
	
	}

}
