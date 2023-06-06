package shop.myshop.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import shop.myshop.dto.ProductDTO;
import shop.myshop.entity.Product;
import shop.myshop.exception.NotExistProductException;
import shop.myshop.repository.ProductRepository;

/* log기록을 하게 해주는 추상화된 로그기록 객체
 * 애노테이션 설정만으로 선언된 해당 클래스의 모든 메소드에 로그 기록 가능
 * */
@Slf4j  
@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private ProductRepository productDao;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public ProductDTO getProduct(Integer productCode) throws NotExistProductException {
		
		return null;
	}
	

	


}
