package shop.myshop.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.Orders;
import shop.myshop.entity.Product;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReviewDTO {
	
	private Integer reviewNo;
	private Product productCode;
	private User userId;
	private Orders orderCode;
	private String reviewContent;
	private String reviewStarScope;
	private Timestamp reviewRegdate;
	private String reviewImage1;
	private String reviewImage2;
	private String reviewImage3;
	
	
	
	
	
}
