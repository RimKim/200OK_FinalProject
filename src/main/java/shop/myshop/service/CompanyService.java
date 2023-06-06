package shop.myshop.service;

import org.springframework.stereotype.Service;

import shop.myshop.dto.ProductDTO;
import shop.myshop.exception.NotExistProductException;

/* 다수의 DAO를 하나의 스펙으로 관리하겠다는 선언
 */
@Service
public interface CompanyService {
	
	//pk로 상품 정보 다 들고오기
	public ProductDTO getProduct(Integer productCode) throws NotExistProductException ;
	

}
