package shop.myshop.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Question;
import shop.myshop.repository.QuestionRepository;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getQuestionCount(String userId) {
		return questionDao.getQuestionwCount(userId);
	}
	
	// 모든 질문글 가져오기
    	public List<Question> getAllQuestions() {
        		return questionDao.findAll();
    	}

	
	  @Override 
	  public void saveQuestion(Question question) throws Exception {
	    questionDao.save(question); 
	  
	  }
	  
	  @Override 
	  public List<Question> getQuestion() throws Exception { return
	   questionDao.getQuestion(); 
	  
	  }
	  
	  @Override 
	  public List<Question> findByQuestionNo(int QuestionNo) throws
	  Exception{ 
		  return questionDao.findByQuestionNo(QuestionNo); 
		  
	  }
	  
	  
	  @Override 
	  public Question findByQuestion(int QuestionNo) throws
	  Exception{ 
		  return questionDao.findByQuestion(QuestionNo); 
		  
	  }
	  
	  @Override 
	  public void deleteByQuestionNo(int QuestionNo) throws Exception{ 
		  questionDao.deleteByQuestionNo(QuestionNo); 
		  }
	
	  

}
	

	
	
	
