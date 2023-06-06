package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.repository.ProductQuestionRepository;


@Service
public class ProductQuestionServiceImpl implements ProductQuestionService{
	
	@Autowired
	private ProductQuestionRepository productQestionDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getProductQuestionCount(String userId) {
		return productQestionDao.getProductQuestionCount(userId);
	}
	

}
	

	
	
	
