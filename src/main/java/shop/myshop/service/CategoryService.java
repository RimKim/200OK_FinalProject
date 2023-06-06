package shop.myshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import shop.myshop.entity.Category;
import shop.myshop.entity.Product;
@Service
public interface CategoryService {


	public Category getCategoryByCategoryNo(Integer CategoryNo);

}
