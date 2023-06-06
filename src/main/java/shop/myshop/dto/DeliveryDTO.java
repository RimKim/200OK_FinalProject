package shop.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import shop.myshop.entity.User;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {
	
private Integer deliveryId;	
private String deliveryName;
private String deliveryMobile;
	private String deliveryAdd1;
	private String deliveryAdd2;
	private String deliveryAdd3;
	private String deliveryBasicyn;
	private String deliveryMemo;
	private User userId;
	
}
