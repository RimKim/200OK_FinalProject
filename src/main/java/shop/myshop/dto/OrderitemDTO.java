package shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderitemDTO {


	private Integer orderitemCode ;


	private Integer orderitemQuantity;
	

	private Product productCode;
	

	private Orders orderCode;
	
	
	
}
