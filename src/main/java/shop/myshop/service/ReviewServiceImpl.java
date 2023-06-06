package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.repository.CartRepository;
import shop.myshop.repository.ReviewRepository;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewRepository reviewDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getReviewCount(String userId) {
		return reviewDao.getReviewCount(userId);
	}
	

}
	

	
	
	
