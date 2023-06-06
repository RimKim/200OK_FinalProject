package shop.myshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.myshop.entity.Category;
import shop.myshop.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryDao;

	
	@Override
	public Category getCategoryByCategoryNo(Integer CategoryNo) {
		return categoryDao.findByCategoryNo(CategoryNo);
	}

	
	

}
	

	
	
	
