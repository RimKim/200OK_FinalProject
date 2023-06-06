package shop.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.myshop.service.CategoryService;


@Controller
@RequestMapping("category")
public class CategoryController {

	
	@Autowired 
	private CategoryService categoryService;
	
	
	
	  
	
}
