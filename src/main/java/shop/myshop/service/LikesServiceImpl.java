package shop.myshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.repository.LikesRepository;


@Service
public class LikesServiceImpl implements LikesService{
	
	@Autowired
	private LikesRepository likesDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public int getLikesCount(String userId) {
		return likesDao.getLikesCount(userId);
	}
	

}
	

	
	
	
